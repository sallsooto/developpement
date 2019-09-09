package org.sfd.gestionHopital.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.validation.Valid;
import org.sfd.gestionHopital.dao.MedecinRepository;
import org.sfd.gestionHopital.dao.ParametrageRepository;
import org.sfd.gestionHopital.dao.PatientRepository;
import org.sfd.gestionHopital.dao.RendezVousRepository;
import org.sfd.gestionHopital.dao.ServiceRepository;
import org.sfd.gestionHopital.entities.Departement;
import org.sfd.gestionHopital.entities.Medecin;
import org.sfd.gestionHopital.entities.Patient;

import org.sfd.gestionHopital.entities.RendezVous;
import org.sfd.gestionHopital.entities.Service;
import org.sfd.gestionHopital.util.CalendarHour;
import org.sfd.gestionHopital.util.DateHeure;
import org.sfd.gestionHopital.util.RvCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class RVController {
	@Autowired
	private ParametrageRepository parametresRepo;
	@Autowired
	private RendezVousRepository rendezVousRepo;
	@Autowired
	private PatientRepository patientRepo;
	@Autowired
	private ServiceRepository serviceRepo;
	@Autowired
	private MedecinRepository  medecinRepo;
	
	//private ParamtresRepository  parametreRepo;
	
	
	/*@Secured(value={"ROLE_Secretaire","ROLE_ADMIN"})
	@RequestMapping(value="/rv")
	public String getRV(Model model) {
		List<Service> listService=new ArrayList<Service>();
		listService=serviceRepo.findAll();
		model.addAttribute("listService",listService);
		model.addAttribute("formRv",new FormAjoutRV());
		//model.addAttribute("medecinId",new MedecinId());
		return "rendezVouspatient";
	}
*/
	/*
	 * @RequestMapping(value="/angular")
	 * 
	 * @ResponseBody public String
	 * angular(@RequestParam(name="numPiece",defaultValue="") String numPiece) {
	 * String patientJson = null; try { Patient patient =
	 * patientRepo.findOnePatientByNum(numPiece); if(patient !=null) {
	 * SimpleDateFormat tf = new SimpleDateFormat("dd/MM/yyyy"); ObjectMapper json =
	 * new ObjectMapper(); json.setDateFormat(tf); patientJson =
	 * json.writeValueAsString(patient); } } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return patientJson; }
	 */
	
//	@RequestMapping(value="/listMedecin")
//	@ResponseBody
//	public String listMedecin(@RequestParam(name="service_id",defaultValue="") Long idS) {
//		 Service service=serviceRepo.getOne(idS);
//		System.out.println(service.getLibelle()+"jhllllllllllll");
//		String medecinJson = null;
//		List<Medecin> listMedecin=medecinRepo.findByService(service);
//		 try { 
//		       if(listMedecin !=null) {
//		    	   for (Medecin medecin : listMedecin) {
//					System.out.println(medecin.getNomComplet()+" "+ medecin.getMatricule());
//				}
//		       ObjectMapper json = new ObjectMapper();
//		        json.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
//		        medecinJson = json.writeValueAsString(listMedecin);
//		       }
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				System.out.println("erreur serieuse:"+e.getMessage());
//				//e.printStackTrace();
//			}
//		
//		return medecinJson;
//	}
	
/*		long i=1;
	  Parametres duree=parametresRepo.findById(i);
		List<String> lesHeures=new ArrayList<>();
		int heures=8,minutes=0;
		while (heures<17) {
			while(minutes<59) {
				
				if (minutes==0) {
					lesHeures.add(heures+":"+"00");
				}
				else
				lesHeures.add(heures+":"+minutes);
				minutes+=duree.getDureeConsultation();
			}
		 minutes=minutes-60;
			
			heures++;
		}
		List<String> datejour=new ArrayList<String>();
		GregorianCalendar calendar =new GregorianCalendar();
		SimpleDateFormat formater=new SimpleDateFormat("dd/MM/yyyy");
		
		int semaine =calendar.get(calendar.WEEK_OF_YEAR);
		//calendar.add(Calendar.DATE, 7);
		
		calendar.set(calendar.DAY_OF_WEEK,calendar.MONDAY);		
		String lundi = formater.format(calendar.getTime());
		datejour.add(lundi);
		
		calendar.set(calendar.DAY_OF_WEEK,calendar.TUESDAY);
		String mardi = formater.format(calendar.getTime());
		datejour.add(mardi);
		
		calendar.set(calendar.DAY_OF_WEEK,calendar.WEDNESDAY);
		String mercredi = formater.format(calendar.getTime());
		datejour.add(mercredi);
		
		calendar.set(calendar.DAY_OF_WEEK,calendar.THURSDAY);
		String jeudi = formater.format(calendar.getTime());
		datejour.add(jeudi);
		
		calendar.set(calendar.DAY_OF_WEEK,calendar.FRIDAY);
		String vendredi= formater.format(calendar.getTime());
		datejour.add(vendredi);
		
		
		model.addAttribute("datej", datejour);
		model.addAttribute("heures", lesHeures);*/
	//@Secured(value={"ROLE_Secretaire","ROLE_ADMIN"})
//	@GetMapping("/rv")
//	public String addView(Model model) {
//		model.addAttribute("services", serviceRepo.findAll());
//		model.addAttribute("formRv", new FormAjoutRV());	
//		return "addRendezVous";
//	}
	
	
	/*
	 * @GetMapping("/delete") public String supprimerRv(Model
	 * model,@RequestParam(name="idrv")Long idrv) { RendezVous
	 * rendezvous=rendezVousRepo.getOne(idrv); rendezVousRepo.delete(rendezvous);
	 * 
	 * return "redirect:/listRv"; }
	 */

	
	

	
	@RequestMapping(value="/calendar",method=RequestMethod.GET)
	public List<RvCalendar> getCalender(
			@RequestParam(name="medecin_id")String med_id,
			@RequestParam(name="datePaterne")String dateP
			
			) {
		try {
			Medecin medecin = new Medecin();
		
			medecin = medecinRepo.findById(Long.parseLong(med_id));
			// util pour la recherche des date inférieure de la date courant
			Calendar currentCalendar = Calendar.getInstance();
			Date date = null;
			SimpleDateFormat tf = null;
			int nbMinuitesByRv = 30;
			List<RvCalendar> dataCalendar = new ArrayList<>();
			// le calender permettant d'icrémenter la date de recheche
			Calendar calendar = new GregorianCalendar();

			// formatage de la date de commencement de parcours
			tf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				date = tf.parse(dateP);//mettre datepatern
			} catch (Exception e) {
				date = new Date();
				//e.printStackTrace();
			}
			calendar.setTime(date);

			int nbDateByCalender = 7, minCommencementRv = 30;

			for (int indexDte = 1; indexDte <= nbDateByCalender; indexDte++) {
				calendar.set(Calendar.MINUTE, minCommencementRv);
				calendar.set(Calendar.HOUR_OF_DAY, 8);
				calendar.set(Calendar.SECOND, 0);

				String formatedHeure = calendar.get(Calendar.HOUR_OF_DAY) < 10 ? "0" + calendar.get(Calendar.HOUR_OF_DAY) : calendar.get(Calendar.HOUR_OF_DAY) + "";
				// parcours à partir des minuites
				String formatedMinuit = calendar.get(Calendar.MINUTE) < 10 ? "0" + calendar.get(Calendar.MINUTE)
						: calendar.get(Calendar.MINUTE) + "";
				// heure confirmement à celui qui doit être récueillie à la base
				String fullFormatedTime = formatedHeure + ":" + formatedMinuit;
				List<CalendarHour> lch = new ArrayList<>();
				List<RendezVous> listeRv = new ArrayList<>();

				// constuction d'une liste des heures occupés
				List<String> listEngagedHours = new ArrayList<>();
				// pourcrours à partir des heures
				while ((calendar.get(Calendar.HOUR_OF_DAY) <= 17)) {
					if (calendar.get(Calendar.HOUR_OF_DAY) == 17 && calendar.get(Calendar.MINUTE) > 30) {
						break;
					}
					formatedHeure = calendar.get(Calendar.HOUR_OF_DAY) < 10 ? "0" + calendar.get(Calendar.HOUR_OF_DAY)
							: calendar.get(Calendar.HOUR_OF_DAY) + "";
					// parcours à partir des minuites
					formatedMinuit = calendar.get(Calendar.MINUTE) < 10 ? "0" + calendar.get(Calendar.MINUTE)
							: calendar.get(Calendar.MINUTE) + "";
					// heure confirmement à celui qui doit être récueillie à la base
					fullFormatedTime = formatedHeure + ":" + formatedMinuit;
					//System.out.println(fullFormatedTime);
					RendezVous rdv = new RendezVous();
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					String dateformater=df.format(calendar.getTime());
					Date d=df.parse(dateformater);
					//System.out.println(d);
					//System.out.println(medecin.getNomComplet()+" "+medecin.getTelephone());
					
					rdv = rendezVousRepo.findByMedecinAndDateRvAndHeureDbAndEtat(medecin, d,
							fullFormatedTime,true);
					if (rdv != null) {
						listeRv.add(rdv);
						System.out.println("un nouveau rv trouver dans la base " + rdv.getHeureDb()
								+ "lid du medecin est" + med_id);//changer apres par medecin_id
					}else {
						System.out.println("un nouveau rv trouver dans la base lid du medecin est" + med_id);
					}
					
					// ajout les heures dans une liste
					if (listeRv.isEmpty() || listeRv == null) {
						CalendarHour ch = null;
						// on controle si c pas le dimache ou le samedi àprès 12
						if ((currentCalendar.getTime().before(calendar.getTime()))
								&& !(calendar.get(Calendar.DAY_OF_WEEK) == 7 && calendar.get(Calendar.HOUR_OF_DAY) > 12))
							ch = new CalendarHour(fullFormatedTime, false);
						else
							ch = new CalendarHour(fullFormatedTime, true);
						lch.add(ch);
					} else {
						for (RendezVous rv : listeRv) {

							listEngagedHours.add(rv.getHeureDb());

						}
						// ajout de l'heure selon son état
						if ((listEngagedHours.contains(fullFormatedTime)
								|| (currentCalendar.getTime().after(calendar.getTime())))) {
							CalendarHour ch = new CalendarHour(fullFormatedTime, true);
							lch.add(ch);
						} else {
							if (calendar.get(Calendar.DAY_OF_WEEK) == 7 && calendar.get(Calendar.HOUR_OF_DAY) > 12) {
								CalendarHour ch = new CalendarHour(fullFormatedTime, true);
								lch.add(ch);
							} else {
								CalendarHour ch = new CalendarHour(fullFormatedTime, false);
								lch.add(ch);
							}
						}
					}
					// incrémentation de la date
					calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + nbMinuitesByRv);
				}
				// concervation du calendirer établie si le jour de la semaine n'est
				// pas dimanche
				if (calendar.get(Calendar.DAY_OF_WEEK) != 1) {
					RvCalendar rvCalendar = new RvCalendar(calendar, lch);
					dataCalendar.add(rvCalendar);
				}
				// incrémentation de la date
				calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
			}

			return dataCalendar;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
		
	}
	
	
	@RequestMapping(value="/rvadd",method=RequestMethod.POST)
	public RendezVous add(
			@RequestParam(name="patient_id")String patient_id,
			@RequestParam(name="medecin_id")String med_id,
			@RequestParam(name="dateRv")String dateRv	
			) {
		try {
			Medecin medecin=new Medecin();
			Patient patient=new Patient();
			medecin=medecinRepo.findById(Long.parseLong(med_id));
			patient=patientRepo.findById(Long.parseLong(patient_id));
			Service service = serviceRepo.getOne(medecin.getService().getId());
			
			if (service != null) {
				System.out.println(medecin.getId()+" est l id du medecin");
				System.out.println("medecin valide" );			
				if (patient == null) {
					patient = new Patient();
					patient = patientRepo.save(patient);
				}
				//Patient patient = patientRepo.findByNumPiece(formAjoutRV.getPatientNumPiece());					
				System.out.println("date rendez vous :"+dateRv);
				Date date = new SimpleDateFormat("dd/MM/yyyy H:mm").parse(dateRv);
				System.out.println("lheure de la variable date est +" + date.toString());
				Calendar cal = new GregorianCalendar();
				cal.setTime(date);
				
				// formatagge de l'heure
				String rvHour = cal.get(Calendar.HOUR_OF_DAY) < 10 ? "0" + cal.get(Calendar.HOUR_OF_DAY)
						: cal.get(Calendar.HOUR_OF_DAY) + "";
				String formatedMinuites = cal.get(Calendar.MINUTE) < 10 ? "0" + cal.get(Calendar.MINUTE)
						: cal.get(Calendar.MINUTE) + "";
				rvHour = rvHour + ":" + formatedMinuites;
				// RendezVous rv = new RendezVous(date, medecin, service,
				// user, true);
				RendezVous rv = new RendezVous();
				rv.setHeureDB(rvHour);
				//rv.set(parametreRepo.getOne((long) 1).getDureeConsultation() + " minutes après");
				rv.setPatient(patient);
				rv.setMedecin(medecin);
				rv.setDateRv(date);
				rv.setEtat(true);
				rv.setService(medecin.getService());
				if (rendezVousRepo.save(rv) != null) {
			System.out.println("Ajout Reussi!!!!!!!!!!!!!!!!!!!!!!");
			return rv;
				}
				else
					System.out.println("echèc de l'enregistrement du rendez-vous");
			} 
			else {
				System.out.println("erreur de la récupération du service");
			}
		
			
		
		} catch (Exception e) {
			//errorMessages.add("Exception: opération échouée");
			System.out.println("Erreur detecte " + e.getMessage());
		}
		return null;
	}
//	
//	@RequestMapping(value="/listRv",method=RequestMethod.GET)
//	public String listConsultation(Model model){
//		List<RendezVous> listrendezVous=rendezVousRepo.findAll();
//		model.addAttribute("listRendezVous",listrendezVous);
//	  
//		return "listRv";
//	}
	 @RequestMapping(value="/rendezVous",method=RequestMethod.GET)
	 public List<RendezVous> getRendzVous(){
		 return rendezVousRepo.findAll();
	 }
	
	@RequestMapping(value="/chercherRvParNumDossier",method=RequestMethod.GET)
	public RendezVous chercherRvParNumDossier(@RequestParam("numDossier")String numeroDossier){
		try {
			return rendezVousRepo.chercherParNumDossier(numeroDossier).get(0);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	@RequestMapping(value="/trouverRvParMedEtPatient",method=RequestMethod.GET)
	public Boolean trouverRvParMedEtPatient(
			@RequestParam("patient_id")String patient_id,
			@RequestParam("med_id")String med_id){
		List <RendezVous> rv=new ArrayList<>();
		rv=rendezVousRepo.trouverParMedEtPatient(Long.parseLong(patient_id),Long.parseLong(med_id));
		if(!rv.isEmpty()) {
			return true;
		}
			
		else
			return false;
	}
}
