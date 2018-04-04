package background.pfc.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import mendeley.pfc.schemas.Folder;
import mendeley.pfc.services.FolderService;
import mendeley.pfc.services.MendeleyService;
import background.pfc.commons.PoolReferences;
import background.pfc.commons.Reference;
import background.pfc.commons.SearchTermParam;
import background.pfc.engine.EngineSearch;
import background.pfc.engine.EngineSearchACM;
import background.pfc.engine.EngineSearchIEEE;
import background.pfc.engine.EngineSearchSCIENCE;
import background.pfc.engine.EngineSearchSPRINGER;
import background.pfc.enums.TypeEngineSearch;

/**
 * BackgroundSearchMendeley es la clase encargada de realizar el proceso de bÃºsqueda
 * en segundo plano de las referencias a importar a Mendeley.
 * 
 * @author angelo
 *
 */
public class BackgroundSearchMendeley {

	private MendeleyService mendeleyService = null;
	private String clientId;
	private String clientSecret;
	private String redirectUri;
	private Map<TypeEngineSearch, Boolean> optionsEngine = new HashMap<TypeEngineSearch, Boolean>();
	private String nameSLR;
	private int tammax;
	private List<String> tags = new ArrayList<String>();
	private int start_year;
	private int end_year;
	private List<SearchTermParam> searchsTerms;
	private Map<TypeEngineSearch,String> apiKeysEngine;
	private int total_hilos;
	private int total_tries;
	private List<Reference> references = new ArrayList<Reference>();
	private String guidStaticData = "";
	private String outputConsole = "";
	
	public BackgroundSearchMendeley(String ci, String cs, String at, String rt, String ru, String email, String pass,
			Map<TypeEngineSearch, Boolean> optionsEngine, String nameSLR, int tammax, List<String> tags, 
			int start_year, int end_year, List<SearchTermParam> searchsTerms, Map<TypeEngineSearch,
			String> apiKeysEngine, int total_hilos, int total_tries, String guidStaticData) throws Exception {

		this.mendeleyService = new MendeleyService(ci,cs,ru,email,pass);
		this.clientId = ci;
		this.clientSecret = cs;
		this.redirectUri = ru;
		this.optionsEngine= optionsEngine;
		this.nameSLR = nameSLR;
		this.tammax = tammax;
		this.tags = tags;
		this.start_year = start_year;
		this.end_year = end_year;
		this.searchsTerms = searchsTerms;
		this.apiKeysEngine = apiKeysEngine;
		this.total_hilos = total_hilos;
		this.total_tries = total_tries;
		this.guidStaticData = guidStaticData;
		
		FolderService folderService = new FolderService(mendeleyService);
		
		Folder folder = folderService.getFolderByName(nameSLR);
		
		if(folder == null)
		{
			throw new Exception("La carpeta no existe.");
		}
	}
	
	public void startSearchs() throws Exception
	{
		//Para evitar que salga el texto por la salida estandar
		org.apache.commons.logging.LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
		Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);
		Logger.getLogger("org.apache.commons.httpclient").setLevel(java.util.logging.Level.OFF);
		
		// AÃ±adimos la busqueda al pool de referencias a buscar
		PoolReferences.addStaticData(guidStaticData);
		
		if(hasEnginesForSearch())
		{
			EngineSearch engineSearch = null;
			
			for(Map.Entry<TypeEngineSearch, Boolean> entry : optionsEngine.entrySet())
			{
				if (Boolean.TRUE.equals(entry.getValue()))
				{
					PoolReferences.addDetails(guidStaticData, "###################################");
					PoolReferences.addDetails(guidStaticData, "### MOTOR DE BÚSQUEDA " + entry.getKey().getKey().toUpperCase());
					PoolReferences.addDetails(guidStaticData, "###################################");
					switch(entry.getKey()) {
						case ACM:
							engineSearch = new EngineSearchACM(clientId, clientSecret, redirectUri, mendeleyService, 
									nameSLR, tammax, tags, start_year, end_year, searchsTerms, apiKeysEngine, 
									total_hilos, total_tries, guidStaticData);
							break;
						case IEEE:
							engineSearch = new EngineSearchIEEE(clientId, clientSecret, redirectUri, mendeleyService, 
									nameSLR, tammax, tags, start_year, end_year, searchsTerms, apiKeysEngine, 
									total_hilos, total_tries, guidStaticData);
							break;
						case SCIENCE:
							engineSearch = new EngineSearchSCIENCE(clientId, clientSecret, redirectUri, mendeleyService, 
									nameSLR, tammax, tags, start_year, end_year, searchsTerms, apiKeysEngine, 
									total_hilos, total_tries, guidStaticData);
							break;
						case SPRINGER:
							engineSearch = new EngineSearchSPRINGER(clientId, clientSecret, redirectUri, mendeleyService, 
									nameSLR, tammax, tags, start_year, end_year, searchsTerms, apiKeysEngine, 
									total_hilos, total_tries, guidStaticData);
							break;
						default:
							break;
					}
					engineSearch.startSearch();
					references.addAll(PoolReferences.getStaticData(guidStaticData).getReferencesEngineSearch());
				} // fin if
			} //fin for
			
			PoolReferences.addDetails(guidStaticData, "PROCESO BÚSQUEDA FINALIZADO");
			
			outputConsole = PoolReferences.getDetails(guidStaticData);
			
			// Eliminamos la busqueda del pool de referencias
			PoolReferences.removeStaticData(guidStaticData);			
		} // fin if
	}
	
	private boolean hasEnginesForSearch()
	{
		boolean result = false;
		
		for(Map.Entry<TypeEngineSearch, Boolean> entry : optionsEngine.entrySet())
		{
			if (Boolean.TRUE.equals(entry.getValue()))
			{
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	public int getTotalReferences()
	{
		return references.size();
	}
	
	public List<Reference> getReferences()
	{
		return references;
	}
	
	public boolean isFinished()
	{
		return PoolReferences.getStaticData(guidStaticData) == null;
	}
	
	public String getOutputConsole()
	{
		return outputConsole == null ? "" : outputConsole;
	}
}
