package es.uca.pfc

import grails.transaction.Transactional;

class SpecificAttributeController {

	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
	def springSecurityService
	def toolService
	
    def index() 
	{ 
		redirect(controller: 'slr', action: 'myList')
	}
	
	@Transactional
	def save()
	{
		boolean isAttributeList = false
		def guidSlr = ""
		
		if (params.guidSlrAttribute.toString().equals("null") || params.guidSlrAttribute.toString().equals(""))
		{
			isAttributeList = true
			guidSlr = params.guidSlr.toString()
		}
		else
		{
			guidSlr = params.guidSlrAttribute.toString()
		}
		
		def slrInstance = Slr.findByGuid(guidSlr)
		
		if (null == slrInstance)
		{
			redirect(controller: 'index', action: 'index')
		}
		else
		{
			String nombreAttribute = params.nombre.toString()
			String tipoAttribute = params.tipo.toString()
			String opcionesAttribute = params.opciones.toString()
			String errorAttribute = ""
			boolean successAttribute = false
			String[] opciones
			List<String> opcionesCorrect = new ArrayList<String>()

			if(nombreAttribute.equals("null") || nombreAttribute.length() < 5)
			{
				errorAttribute = "ERROR: The name must have 5 characters or more."
			}
			else if(tipoAttribute.equals("list") && (opcionesAttribute.trim().equals("") || opcionesAttribute.trim().equals(" ") || (null == params.opciones)))
			{
				errorAttribute = "ERROR: The list type must have one or more options."
			}
			else
			{
				nombreAttribute = nombreAttribute.toLowerCase();
				def attributeInstance = SpecificAttribute.findBySlrAndNameLike(slrInstance, nombreAttribute)
				
				if (null != attributeInstance)
				{
					errorAttribute = "ERROR: The name is used for other attribute."
				}
				else if (tipoAttribute.equals("list"))
				{
					opciones = opcionesAttribute.toString().trim().toLowerCase().split(";")
					
					for(int i=0; i<opciones.length; i++)
					{
						if(!opciones[i].equals(null) && !opciones[i].toString().trim().toLowerCase().equals("") && !opciones[i].toString().trim().toLowerCase().equals("null") && !opciones[i].toString().trim().toLowerCase().equals(" "))
						{
							opcionesCorrect.add(opciones[i])
						}
					}
					
					if (opcionesCorrect.size() == 0)
					{
						errorAttribute = "ERROR: The list type must have one or more options."
					}
				}
				
				if (errorAttribute.equals(""))
				{
					if(tipoAttribute == "list")
					{
						attributeInstance = new SpecificAttributeMultipleValue(name: nombreAttribute)
						
						attributeInstance.addToOptions("--") // opcion en blanco por defecto
						
						for(String op : opcionesCorrect)
						{
							attributeInstance.addToOptions(op)
						}
						attributeInstance.optionDefault = "--"
					}
					else
					{
						attributeInstance = new SpecificAttribute(name: nombreAttribute, tipo: tipoAttribute)
					}

					slrInstance.addToSpecAttributes(attributeInstance)
					slrInstance.save(failOnError: true)
					successAttribute = true
					
					// Insertamos el nuevo atributo en cada una de las referencias
					for(Search search : slrInstance.searchs)
					{
						for(Reference reference : search.references)
						{
							if (tipoAttribute == "list")
							{
								reference.addToSpecificAttributes(attribute: attributeInstance, value: attributeInstance.optionDefault)
							}
							else
							{
								reference.addToSpecificAttributes(attribute: attributeInstance)
							}
							reference.save(failOnError: true)
						}
					}
				}
			}
			
			// Procede de la lista de atributos
			if (isAttributeList)
			{
				redirect(controller: 'slr', action: 'specAttributes', params: [errorAttribute: errorAttribute, successAttribute: successAttribute,
																	   nombreAttribute: nombreAttribute, opcionesAttribute: opcionesAttribute,
																	   tipoAttribute: tipoAttribute, guid: guidSlr])
			}
			else // Procede de la lista de slrs
			{
				redirect(controller: 'slr', action: 'myList', params: [errorAttribute: errorAttribute, successAttribute: successAttribute,
																		nombreAttribute: nombreAttribute, opcionesAttribute: opcionesAttribute,
																		tipoAttribute: tipoAttribute, guidSlrError: guidSlr])
			}
		}
	}
	
	@Transactional
	def edit()
	{
		boolean isAttributeList = false
		def guidSlr = ""
		
		if (params.guidSlrAttribute.toString().equals("null") || params.guidSlrAttribute.toString().equals(""))
		{
			isAttributeList = true
			guidSlr = params.guidSlr.toString()
		}
		else
		{
			guidSlr = params.guidSlrAttribute.toString()
		}
		
		def slrInstance = Slr.findByGuid(guidSlr)
		
		if (null == slrInstance)
		{
			redirect(controller: 'index', action: 'index')
		}
		else
		{
			def idEditAttribute = params.idEditAttribute.toString()
			def attributeEditInstance = SpecificAttribute.get(Long.parseLong(idEditAttribute))
			
			String nombreEditAttribute = params.nombreEdit.toString()
			String tipoEditAttribute = params.tipoEdit.toString()
			String opcionesEditAttribute = params.opcionesEdit.toString()
			String errorEditAttribute = ""
			boolean successEditAttribute = false
			String[] opcionesEdit
			List<String> opcionesEditCorrect = new ArrayList<String>()

			if(nombreEditAttribute.equals("null") || nombreEditAttribute.length() < 5)
			{
				errorEditAttribute = "ERROR: The name must have 5 characters or more."
			}
			else if(tipoEditAttribute.equals("list") && (opcionesEditAttribute.trim().equals("") || opcionesEditAttribute.trim().equals(" ") || (null == params.opcionesEdit)))
			{
				errorEditAttribute = "ERROR: The list type must have one or more options."
			}
			else
			{
				nombreEditAttribute = nombreEditAttribute.toLowerCase();
				def attributeInstance = SpecificAttribute.findBySlrAndNameLike(slrInstance, nombreEditAttribute)
				
				if (null != attributeInstance)
				{
					errorEditAttribute = "ERROR: The name is used for other attribute."
				}
				else if (tipoEditAttribute.equals("list"))
				{
					opcionesEdit = opcionesEditAttribute.toString().trim().toLowerCase().split(";")
					
					for(int i=0; i<opcionesEdit.length; i++)
					{
						if(!opcionesEdit[i].equals(null) && !opcionesEdit[i].toString().trim().toLowerCase().equals("") && !opcionesEdit[i].toString().trim().toLowerCase().equals("null") && !opcionesEdit[i].toString().trim().toLowerCase().equals(" "))
						{
							opcionesEditCorrect.add(opciones[i])
						}
					}
					
					if (opcionesEditCorrect.size() == 0)
					{
						errorEditAttribute = "ERROR: The list type must have one or more options."
					}
				}
				
				if (errorEditAttribute.equals(""))
				{
					attributeEditInstance.name = nombreEditAttribute
					attributeEditInstance.save(failOnError: true)
					successEditAttribute = true
				}
			}
			
			// Procede de la lista de atributos
			redirect(controller: 'slr', action: 'specAttributes', params: [errorEditAttribute: errorEditAttribute, successEditAttribute: successEditAttribute,
																	   nombreEditAttribute: nombreEditAttribute, opcionesEditAttribute: opcionesEditAttribute,
																	   tipoEditAttribute: tipoEditAttribute, guid: guidSlr, idEditAttribute: idEditAttribute])
		}
	}
	
	@Transactional
	def delete()
	{
		def idAttribute = params.idAttribute.toString()
		def guidSlr = params.guidSlr.toString()
		
		def attributeInstance = SpecificAttribute.get(Long.parseLong(idAttribute))
		def slrInstance = Slr.findByGuid(guidSlr)
		
		toolService.deleteSpecificAttribute(attributeInstance, slrInstance)
		
		redirect(controller: 'slr', action: 'specAttributes', params: [guid: guidSlr])
	}
}
