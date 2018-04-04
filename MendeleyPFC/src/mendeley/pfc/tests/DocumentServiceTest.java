package mendeley.pfc.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

import mendeley.pfc.commons.MendeleyException;
import mendeley.pfc.commons.TypeDocument;
import mendeley.pfc.schemas.Document;
import mendeley.pfc.schemas.Folder;
import mendeley.pfc.services.DocumentService;
import mendeley.pfc.services.FolderService;
import mendeley.pfc.services.MendeleyService;

public class DocumentServiceTest {

	public static final String APP_EMAIL = "angel.gonzatoro@gmail.com";
	public static final String APP_PASS  = "Number98*";
	public static final String APP_ID = "4347";
	public static final String APP_URL = "http://localhost:8080/SLR/indexMendeley/";
	public static final String APP_CODE_SECRET = "XJZuvpCKISNcnLBo";
	
	public static void main(String[] args) {
		
		try 
		{
			MendeleyService mendeleyService = new MendeleyService(APP_ID, APP_CODE_SECRET, APP_URL, APP_EMAIL, APP_PASS, "", "");

			FolderService folderService = new FolderService(mendeleyService);
			DocumentService documentService = new DocumentService(mendeleyService);
			
			Folder folder = folderService.getFolderByName("SLR: Title 2");
			Folder folderIEEE = folderService.getSubFolder(folder.getId(), "ieee");
			
			List<Document> documents = folderService.getDocuments(folderIEEE);
			
			for(Document document : documents) {
				System.out.println(document.getId() + " => " + document.getCitationKey());
				//System.out.println(documentService.getBibtex(document));
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
