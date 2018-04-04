package es.uca.pfc

import grails.transaction.Transactional;

class WizardSlrController {

	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
	def springSecurityService
	def toolService
	def mendeleyToolService
	int maxStrTitle = 20
	
    def index() 
	{
		redirect(controller: 'index', action: 'index')
	}
	
	def createSLR()
	{
		User userInstance = User.get(Long.parseLong(springSecurityService.principal.id.toString()))
		def error = ""
		def tituloSlr = ""
		def justificacionSlr = ""
		
		if(userInstance == null)
		{
			redirect(controller: 'index', action: 'index')
		}
		else
		{
			if(!(null == params.error || params.error.equals(null)))
			{
				error = params.error.toString()
			}
			
			if(!(params.tituloSlr == null || params.tituloSlr.equals(null)))
			{
				tituloSlr = params.tituloSlr.toString()
			}
			
			if(!(params.justificacionSlr == null || params.justificacionSlr.equals(null)))
			{
				justificacionSlr = params.justificacionSlr.toString()
			}

			[error: error, tituloSlr: tituloSlr, justificacionSlr: justificacionSlr]
		}
	}
	
	@Transactional
	def saveSLR()
	{
		String tituloSlr = params.titulo.toString()
		String justificacionSlr = params.justificacion.toString()
		User userInstance = User.get(Long.parseLong(springSecurityService.principal.id.toString()))
		String error = ""
		
		if(userInstance == null)
		{
			redirect(controller: 'index', action: 'index')
		}
		else if (tituloSlr.equals("null") || tituloSlr.length() <= 5 )
		{
			error = "ERROR: The name must have 5 or more characters."
		}
		else if (justificacionSlr.equals("null") || justificacionSlr.length() <= 2 )
		{
			error = "ERROR: The justification must have 5 or more characters"
		}
		else
		{
			tituloSlr = "SLR: " + params.titulo.toString().trim()
			
			def mySlrs = Slr.findAllByUserProfileAndTitleLike(userInstance.userProfile, tituloSlr)
			
			if(mySlrs.size() > 0) // Hay repetidos con ese nombre
			{
				error = "ERROR: The name of SLR is used."
			}
		}
		
		if(error.equals(""))
		{
			// Creamos el Slr en BD
			Slr newSlrInstance = new Slr(title: tituloSlr, justification: justificacionSlr, userProfile: userInstance.userProfile, idmend: tituloSlr)
			newSlrInstance = newSlrInstance.save flush: true
			
			// Creamos el Slr en Mendeley
			boolean isCreated = mendeleyToolService.createSlrMendeley(userInstance, newSlrInstance)
			
			if (isCreated)
			{
				// Creamos preguntas de investigacion
				redirect(controller: 'wizardSlr', action: 'createResQuestions', params: [guid: newSlrInstance.guid])
			}
			else
			{
				error = "ERROR: Problems with the synchro. Try again later.."
				redirect(controller: 'wizardSlr', action: 'createSLR',
					params: [error: error,
							 tituloSlr: params.titulo,
							 justificacionSlr: params.justificacion])
			}
		}
		else
		{
			redirect(controller: 'wizardSlr', action: 'createSLR',
					params: [error: error,
							 tituloSlr: params.titulo,
							 justificacionSlr: params.justificacion])
		}
	}
	
	def createResQuestions()
	{
		def isLogin = springSecurityService.loggedIn
		
		// Si no existe el guid, redirigimos a index
		if(!isLogin || !params.guid || params.guid.equals(""))
		{
			redirect(controller: 'index', action: 'index')
		}
		else
		{
			// Comprobamos si se va a crear un nuevo SLR.
			def errorQuestion = ""
			def successQuestion = false
			def enunciadoQuestion = ""
			def errorEditQuestion = ""
			def successEditQuestion = false
			def enunciadoEditQuestion = ""
			def idEditQuestion = 0
			def errorTotal = ""

			if(!(null == params.idEditQuestion || params.idEditQuestion.equals(null)))
			{
				idEditQuestion = Long.parseLong(params.idEditQuestion.toString())
			}
			
			if(params.successQuestion.toString().equals("true"))
			{
				successQuestion = true
			}
			
			if(params.successEditQuestion.toString().equals("true"))
			{
				successEditQuestion = true
			}
		
			if(!(null == params.errorQuestion || params.errorQuestion.equals(null)))
			{
				errorQuestion = params.errorQuestion.toString()
			}
			
			if(!(null == params.errorEditQuestion || params.errorEditQuestion.equals(null)))
			{
				errorEditQuestion = params.errorEditQuestion.toString()
			}
			
			if(!(params.enunciadoQuestion == null || params.enunciadoQuestion.equals(null) || successQuestion))
			{
				enunciadoQuestion = params.enunciadoQuestion.toString()
			}

			if(!(params.enunciadoEditQuestion == null || params.enunciadoEditQuestion.equals(null) || successEditQuestion))
			{
				enunciadoEditQuestion = params.enunciadoEditQuestion.toString()
			}

			if(!(params.errorTotal == null || params.errorTotal.equals(null)))
			{
				errorTotal = params.errorTotal.toString()
			}
			
			def slrInstance = Slr.findByGuid(params.guid)
			
			def userLogin = User.get(springSecurityService.principal.id)
			if(userLogin.userProfile != slrInstance.userProfile)
			{
				redirect(controller: 'index', action: 'index')
			}
			
			def slrBreadCrumb = (slrInstance.title.toString().length() > maxStrTitle ? slrInstance.title.toString().substring(0,maxStrTitle)+"..." : slrInstance.title)
			
			[slrInstance: slrInstance, questionListInstance: slrInstance.questions,
			 errorQuestion: errorQuestion, successQuestion: successQuestion,
			 enunciadoQuestion: enunciadoQuestion, slrBreadCrumb: slrBreadCrumb,
			 errorEditQuestion: errorEditQuestion, successEditQuestion: successEditQuestion,
			 enunciadoEditQuestion: enunciadoEditQuestion, idEditQuestion: idEditQuestion,
			 errorTotal: errorTotal]
		}
	}
	
	@Transactional
	def saveResQuestions()
	{
		boolean isQuestionList = false
		def guidSlr = ""
		
		if (params.guidSlrQuestion.toString().equals("null") || params.guidSlrQuestion.toString().equals(""))
		{
			isQuestionList = true
			guidSlr = params.guidSlr.toString()
		}
		else
		{
			guidSlr = params.guidSlrQuestion.toString()
		}
		
		def slrInstance = Slr.findByGuid(guidSlr)
		
		if (null == slrInstance)
		{
			redirect(controller: 'index', action: 'index')
		}
		else
		{
			String enunciadoQuestion = params.enunciado.toString()
			String errorQuestion = ""
			boolean successQuestion = false
			
			if(enunciadoQuestion.equals("null") || enunciadoQuestion.length() <= 5)
			{
				errorQuestion = "ERROR: The statement must have 5 or more characters."
			}
			else
			{
				enunciadoQuestion = enunciadoQuestion.toLowerCase();
				def questionInstance = ResearchQuestion.findBySlrAndEnunciadoLike(slrInstance, enunciadoQuestion)
				
				if (null != questionInstance)
				{
					errorQuestion = "ERROR: The statement is used."
				}
				
				if (errorQuestion.equals(""))
				{
					questionInstance = new ResearchQuestion(enunciado: enunciadoQuestion)
					slrInstance.addToQuestions(questionInstance)
					slrInstance.save(failOnError: true)
					successQuestion = true
				}
			}
			
			// Step3
			redirect(controller: 'wizardSlr', action: 'createResQuestions', params: [errorQuestion: errorQuestion, successQuestion: successQuestion,
																	   enunciadoQuestion: enunciadoQuestion, guid: guidSlr])
		}
	}
	
	@Transactional
	def editResQuestions()
	{
		boolean isQuestionList = false
		def guidSlr = ""
		
		if (params.guidSlrQuestion.toString().equals("null") || params.guidSlrQuestion.toString().equals(""))
		{
			isQuestionList = true
			guidSlr = params.guidSlr.toString()
		}
		else
		{
			guidSlr = params.guidSlrQuestion.toString()
		}
		
		def slrInstance = Slr.findByGuid(guidSlr)
		
		if (null == slrInstance)
		{
			redirect(controller: 'index', action: 'index')
		}
		else
		{
			def idEditQuestion = params.idEditQuestion.toString()
			def questionEditInstance = ResearchQuestion.get(Long.parseLong(idEditQuestion))
			
			String enunciadoEditQuestion = params.enunciadoEdit.toString()
			String errorEditQuestion = ""
			boolean successEditQuestion = false
			
			if(enunciadoEditQuestion.equals("null") || enunciadoEditQuestion.length() <= 5)
			{
				errorEditQuestion = "ERROR: The statement must have 5 or more characters."
			}
			else
			{
				enunciadoEditQuestion = enunciadoEditQuestion.toLowerCase();
				def questionInstance = ResearchQuestion.findBySlrAndEnunciadoLike(slrInstance, enunciadoEditQuestion)
				
				if (null != questionInstance)
				{
					errorEditQuestion = "ERROR: The statement is used."
				}
				
				if (errorEditQuestion.equals(""))
				{
					questionEditInstance.enunciado = enunciadoEditQuestion
					questionEditInstance.save(failOnError: true)
					successEditQuestion = true
				}
			}
			
			redirect(controller: 'wizardSlr', action: 'createResQuestions', params: [errorEditQuestion: errorEditQuestion, successEditQuestion: successEditQuestion,
																	   			enunciadoEditQuestion: enunciadoEditQuestion, idEditQuestion: questionEditInstance.id,
																			    guid: guidSlr])
		}
	}
	
	@Transactional
	def deleteResQuestions()
	{
		def idQuestion = params.idQuestion.toString()
		def guidSlr = params.guidSlr.toString()
		
		def questionInstance = ResearchQuestion.get(Long.parseLong(idQuestion))
		
		if(questionInstance != null)
		{
			questionInstance.delete flush: true
		}
		
		redirect(controller: 'wizardSlr', action: 'createResQuestions', params: [guid: guidSlr])
	}
	
	def createCriterions()
	{
		def isLogin = springSecurityService.loggedIn
		
		// Si no existe el guid, redirigimos a index
		if(!isLogin || !params.guid || params.guid.equals(""))
		{
			redirect(controller: 'index', action: 'index')
		}
		else
		{
			def slrInstance = Slr.findByGuid(params.guid)

			if(slrInstance == null)
			{
				redirect(controller: 'index', action: 'index')
			}
			else
			{
				if(slrInstance.questions.size() == 0)
				{
					redirect(controller: 'wizardSlr', action: 'createResQuestions', params: [guid: slrInstance.guid, errorTotal: "ERROR: You must create one or more researchs questions."])
					return
				}

				// Comprobamos si se va a crear un nuevo SLR.
				def errorCriterion = ""
				def successCriterion = false
				def nombreCriterion = ""
				def descripcionCriterion = ""
				def errorEditCriterion = ""
				def successEditCriterion = false
				def nombreEditCriterion = ""
				def descripcionEditCriterion = ""
				def idEditCriterion = 0
				
				if(!(null == params.idEditCriterion || params.idEditCriterion.equals(null)))
				{
					idEditCriterion = Long.parseLong(params.idEditCriterion.toString())
				}
				
				if(params.successCriterion.toString().equals("true"))
				{
					successCriterion = true
				}
				
				if(params.successEditCriterion.toString().equals("true"))
				{
					successEditCriterion = true
				}
	
				if(!(null == params.errorCriterion || params.errorCriterion.equals(null)))
				{
					errorCriterion = params.errorCriterion.toString()
				}
				
				if(!(null == params.errorEditCriterion || params.errorEditCriterion.equals(null)))
				{
					errorEditCriterion = params.errorEditCriterion.toString()
				}
				
				if(!(params.nombreCriterion == null || params.nombreCriterion.equals(null) || successCriterion))
				{
					nombreCriterion = params.nombreCriterion.toString()
				}
				
				if(!(params.nombreEditCriterion == null || params.nombreEditCriterion.equals(null) || successEditCriterion))
				{
					nombreEditCriterion = params.nombreEditCriterion.toString()
				}
				
				if(!(params.descripcionCriterion == null || params.descripcionCriterion.equals(null) || successCriterion))
				{
					descripcionCriterion = params.descripcionCriterion.toString()
				}
	
				if(!(params.descripcionEditCriterion == null || params.descripcionEditCriterion.equals(null) || successCriterion))
				{
					descripcionEditCriterion = params.descripcionEditCriterion.toString()
				}
	
				def userLogin = User.get(springSecurityService.principal.id)
				if(userLogin.userProfile != slrInstance.userProfile)
				{
					redirect(controller: 'index', action: 'index')
				}
				
				// Calculamos el n�mero de referencias con los criterios
				Map<String, Integer> totalReferences = new HashMap<String,Integer>()
				for(Search search : slrInstance.searchs)
				{
					for(Reference reference : search.references)
					{
						if (null == totalReferences.get(reference.criterion.name))
						{
							totalReferences.put(reference.criterion.name, 1)
						}
						else
						{
							totalReferences.put(reference.criterion.name, totalReferences.get(reference.criterion.name).value+1)
						}
					}
				}
				
				def slrBreadCrumb = (slrInstance.title.toString().length() > maxStrTitle ? slrInstance.title.toString().substring(0,maxStrTitle)+"..." : slrInstance.title)
				
				[slrInstance: slrInstance, criterionListInstance: slrInstance.criterions,
				 errorCriterion: errorCriterion, successCriterion: successCriterion,
				 nombreCriterion: nombreCriterion, descripcionCriterion: descripcionCriterion,
				 errorEditCriterion: errorEditCriterion, successEditCriterion: successEditCriterion,
				 nombreEditCriterion: nombreEditCriterion, descripcionEditCriterion: descripcionEditCriterion,
				 totalReferences: totalReferences, slrBreadCrumb: slrBreadCrumb, idEditCriterion: idEditCriterion]
			}
		}
	}
	
	@Transactional
	def saveCriterions()
	{
		boolean isCriterionList = false
		def guidSlr = ""
		
		guidSlr = params.guidSlr.toString()
		
		def slrInstance = Slr.findByGuid(guidSlr)
		
		if (null == slrInstance)
		{
			redirect(controller: 'index', action: 'index')
		}
		else
		{
			String nombreCriterion = params.nombre.toString()
			String descripcionCriterion = params.descripcion.toString()
			String errorCriterion = ""
			boolean successCriterion = false
			
			if(nombreCriterion.equals("null") || nombreCriterion.length() <= 5)
			{
				errorCriterion = "ERROR: The name must have 5 or more characters."
			}
			else if (descripcionCriterion.equals("null") || descripcionCriterion.length() <= 5)
			{
				errorCriterion = "ERROR: The description must have 5 or more characters."
			}
			else
			{
				nombreCriterion = nombreCriterion.toLowerCase();
				def criterionInstance = Criterion.findBySlrAndNameLike(slrInstance, nombreCriterion)
				
				if (null != criterionInstance)
				{
					errorCriterion = "ERROR: The criterion is used."
				}
				
				if (errorCriterion.equals(""))
				{
					criterionInstance = new Criterion(name: nombreCriterion, description: descripcionCriterion, nomenclatura: "cr_"+nombreCriterion)
					slrInstance.addToCriterions(criterionInstance)
					slrInstance.save(failOnError: true)
					successCriterion = true
				}
			}
			
			redirect(controller: 'wizardSlr', action: 'createCriterions', params: [errorCriterion: errorCriterion, successCriterion: successCriterion,
																		nombreCriterion: nombreCriterion, descripcionCriterion: descripcionCriterion,
																		guid: guidSlr])
		}
	}
	
	@Transactional
	def editCriterions()
	{
		boolean isCriterionList = false
		def guidSlr = ""
		
		guidSlr = params.guidSlr.toString()
		
		def slrInstance = Slr.findByGuid(guidSlr)
		
		if (null == slrInstance)
		{
			redirect(controller: 'index', action: 'index')
		}
		else
		{
			def idEditCriterion = params.idEditCriterion.toString()
			def criterionEditInstance = Criterion.get(Long.parseLong(idEditCriterion))
			
			String nombreEditCriterion = params.nombreEdit.toString()
			String descripcionEditCriterion = params.descripcionEdit.toString()
			String errorEditCriterion = ""
			boolean successEditCriterion = false
			
			if(nombreEditCriterion.equals("null") || nombreEditCriterion.length() <= 5)
			{
				errorEditCriterion = "ERROR: The name must have 5 or more characters."
			}
			else if (descripcionEditCriterion.equals("null") || descripcionEditCriterion.length() <= 5)
			{
				errorEditCriterion = "ERROR: The description must have 5 or more characters."
			}
			else
			{
				nombreEditCriterion = nombreEditCriterion.toLowerCase();
				def criterionInstance = Criterion.findBySlrAndNameLike(slrInstance, nombreEditCriterion)
				
				if (null != criterionInstance)
				{
					errorEditCriterion = "ERROR: The criterion is used."
				}
				
				if (errorEditCriterion.equals(""))
				{
					criterionEditInstance.name = nombreEditCriterion
					criterionEditInstance.description = descripcionEditCriterion
					slrInstance.save(failOnError: true)
					successEditCriterion = true

				}
			}
			
			redirect(controller: 'wizardSlr', action: 'createCriterions', params: [errorEditCriterion: errorEditCriterion, successEditCriterion: successEditCriterion,
																		nombreEditCriterion: nombreEditCriterion, descripcionEditCriterion: descripcionEditCriterion,
																		guid: guidSlr, idEditCriterion: idEditCriterion])
		}
	}
	
	@Transactional
	def deleteCriterions()
	{
		def idCriterion = params.idCriterion.toString()
		def guidSlr = params.guidSlr.toString()
		
		def criterionInstance = Criterion.get(Long.parseLong(idCriterion))
		def slrInstance = Slr.findByGuid(guidSlr)
		def criterionIncluded = Criterion.findByNomenclaturaLikeAndSlr("cr_included",slrInstance)
		
		if(criterionInstance != null)
		{
			// Actualizamos las referencias
			for(Search search : slrInstance.searchs)
			{
				for(Reference reference : search.references)
				{
					if (reference.criterion == criterionInstance)
					{
						reference.criterion = criterionIncluded
						reference.save(failOnError: true)
					}
				}
			}
			
			criterionInstance.delete flush: true
		}
		
		redirect(controller: 'wizardSlr', action: 'createCriterions', params: [guid: guidSlr])
	}
	
	def createSpecAttributes()
	{
		def isLogin = springSecurityService.loggedIn
		
		// Si no existe el guid, redirigimos a index
		if(!isLogin || !params.guid || params.guid.equals(""))
		{
			redirect(controller: 'index', action: 'index')
		}
		else
		{
			// Comprobamos si se va a crear un nuevo SLR.
			def errorAttribute = ""
			def successAttribute = false
			def nombreAttribute = ""
			def opcionesAttribute = ""
			def tipoAttribute = "string"
			def errorEditAttribute = ""
			def successEditAttribute = false
			def nombreEditAttribute = ""
			def idEditAttribute = 0
			
			if(!(null == params.idEditAttribute || params.idEditAttribute.equals(null)))
			{
				idEditAttribute = Long.parseLong(params.idEditAttribute.toString())
			}
			
			if(params.successAttribute.toString().equals("true"))
			{
				successAttribute = true
			}
			
			if(params.successEditAttribute.toString().equals("true"))
			{
				successEditAttribute = true
			}
		
			if(!(null == params.errorAttribute || params.errorAttribute.equals(null)))
			{
				errorAttribute = params.errorAttribute.toString()
			}
			
			if(!(null == params.errorEditAttribute || params.errorEditAttribute.equals(null)))
			{
				errorEditAttribute = params.errorEditAttribute.toString()
			}
			
			if(!(params.nombreAttribute == null || params.nombreAttribute.equals(null) || successAttribute))
			{
				nombreAttribute = params.nombreAttribute.toString()
			}
			
			if(!(params.nombreEditAttribute == null || params.nombreEditAttribute.equals(null) || successEditAttribute))
			{
				nombreEditAttribute = params.nombreEditAttribute.toString()
			}
			
			if(!(params.tipoAttribute == null || params.tipoAttribute.equals(null) || successAttribute))
			{
				tipoAttribute = params.tipoAttribute.toString()
			}
			
			if(!(params.opcionesAttribute == null || params.opcionesAttribute.equals(null) || successAttribute))
			{
				opcionesAttribute = params.opcionesAttribute.toString()
			}
			
			def slrInstance = Slr.findByGuid(params.guid)
			
			def userLogin = User.get(springSecurityService.principal.id)
			if(userLogin.userProfile != slrInstance.userProfile)
			{
				redirect(controller: 'index', action: 'index')
			}
			
			def slrBreadCrumb = (slrInstance.title.toString().length() > maxStrTitle ? slrInstance.title.toString().substring(0,maxStrTitle)+"..." : slrInstance.title)
			
			[slrInstance: slrInstance, specAttributesListInstance: slrInstance.specAttributes,
			 errorAttribute: errorAttribute, successAttribute: successAttribute,
			 nombreAttribute: nombreAttribute, opcionesAttribute: opcionesAttribute,
			 tipoAttribute: tipoAttribute, slrBreadCrumb: slrBreadCrumb,
			 errorEditAttribute: errorEditAttribute, successEditAttribute: successEditAttribute,
			 nombreEditAttribute: nombreAttribute,idEditAttribute: idEditAttribute]
		}
	}
	
	@Transactional
	def saveSpecAttributes()
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
			
			redirect(controller: 'wizardSlr', action: 'createSpecAttributes', params: [errorAttribute: errorAttribute, successAttribute: successAttribute,
																	   nombreAttribute: nombreAttribute, opcionesAttribute: opcionesAttribute,
																	   tipoAttribute: tipoAttribute, guid: guidSlr])
		}
	}
	
	@Transactional
	def editSpecAttributes()
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
			
			redirect(controller: 'wizardSlr', action: 'createSpecAttributes', params: [errorEditAttribute: errorEditAttribute, successEditAttribute: successEditAttribute,
																	   nombreEditAttribute: nombreEditAttribute, opcionesEditAttribute: opcionesEditAttribute,
																	   tipoEditAttribute: tipoEditAttribute, guid: guidSlr, idEditAttribute: idEditAttribute])
		}
	}
	
	@Transactional
	def deleteSpecAttributes()
	{
		def idAttribute = params.idAttribute.toString()
		def guidSlr = params.guidSlr.toString()
		
		def attributeInstance = SpecificAttribute.get(Long.parseLong(idAttribute))
		def slrInstance = Slr.findByGuid(guidSlr)
		
		toolService.deleteSpecificAttribute(attributeInstance, slrInstance)
		
		redirect(controller: 'wizardSlr', action: 'createSpecAttributes', params: [guid: guidSlr])
	}
	
	def createSearch()
	{
		def isLogin = springSecurityService.loggedIn
		
		String guidSlr = (null == params.guidSlr ? "" : params.guidSlr.toString())
		
		if(!isLogin || guidSlr.equals(""))
		{
			redirect(controller: 'index', action: 'index')
		}
		else
		{
			def slrInstance = Slr.findByGuid(guidSlr)
			def error = (null == params.error ? "" : params.error.toString())
			
			if (null == slrInstance)
			{
				redirect(controller: 'index', action: 'index')
			}
			else
			{
				def minYearSearch = (null == params.minYearSearch ? 1980 : Integer.parseInt(params.minYearSearch.toString()))
				def maxYearSearch = (null == params.maxYearSearch ? Calendar.getInstance().get(Calendar.YEAR) : Integer.parseInt(params.maxYearSearch.toString()))
				def maxTotalSearch = params.maxTotalSearch
				
				def engineListInstance = EngineSearch.findAllByStatusAndNameNotIlike(true, "other")
				def operatorListInstance = SearchOperator.list(sort:'name', order: 'asc')
				def componentListInstance = SearchComponent.list(sort:'name', order: 'asc')
				def minYear = 1980
				def maxYear = Calendar.getInstance().get(Calendar.YEAR);
				
				def strOptionsOperators = toolService.converterToStrOptions(operatorListInstance)
				def strOptionsComponents = toolService.converterToStrOptions(componentListInstance)
				
				[
					slrInstance: slrInstance, error: error, engineListInstance: engineListInstance,
					operatorListInstance: operatorListInstance, componentListInstance: componentListInstance,
					minYear: minYear, maxYear: maxYear,
					minYearSearch: minYearSearch,
					maxYearSearch: maxYearSearch,
					maxTotalSearch: maxTotalSearch,
					strOptionsOperators: strOptionsOperators,
					strOptionsComponents: strOptionsComponents
				]
			}
		}
	}
}
