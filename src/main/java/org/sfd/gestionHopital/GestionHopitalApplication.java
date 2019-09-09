package org.sfd.gestionHopital;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import org.sfd.gestionHopital.dao.AnteDossierRepository;
import org.sfd.gestionHopital.dao.AntecedentRepository;
import org.sfd.gestionHopital.dao.ConsultationRepository;
import org.sfd.gestionHopital.dao.DepartementRepository;
import org.sfd.gestionHopital.dao.DossierRepository;
import org.sfd.gestionHopital.dao.MedecinRepository;
import org.sfd.gestionHopital.dao.PatientRepository;
import org.sfd.gestionHopital.dao.RoleRepository;
import org.sfd.gestionHopital.dao.ServiceRepository;
import org.sfd.gestionHopital.dao.SpecialiteRepository;
import org.sfd.gestionHopital.dao.UtilisateurRepository;
import org.sfd.gestionHopital.entities.AnteDossier;
import org.sfd.gestionHopital.entities.Antecedent;
import org.sfd.gestionHopital.entities.Consultation;
import org.sfd.gestionHopital.entities.Departement;
import org.sfd.gestionHopital.entities.Dossier;
import org.sfd.gestionHopital.entities.Medecin;
import org.sfd.gestionHopital.entities.Patient;
import org.sfd.gestionHopital.entities.Role;
import org.sfd.gestionHopital.entities.Service;
import org.sfd.gestionHopital.entities.Specialite;
import org.sfd.gestionHopital.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableAutoConfiguration
public class GestionHopitalApplication implements CommandLineRunner {
	@Autowired
	private ServiceRepository serviceRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private DossierRepository dossierRepository;
	@Autowired
	private AntecedentRepository antecedentRepository;
	@Autowired
	private AnteDossierRepository anteDossierRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private DepartementRepository departementRepository;
	@Autowired
	private MedecinRepository medecinRepository;
	@Autowired
	private ConsultationRepository consultationRepository;
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private SpecialiteRepository specialiteRepository;


	public static void main(String[] args) {
		SpringApplication.run(GestionHopitalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		accountService.saveRole(new Role("USER"));
		accountService.saveRole(new Role("ADMIN"));
		accountService.saveRole(new Role("MEDECIN"));
		accountService.saveRole(new Role("SECRETAIRE"));
		accountService.saveRole(new Role("CHEFSERVICE"));
		Stream.of("user1", "med1", "sec1", "admin").forEach(un -> {
			accountService.saveUser1(un, "1234", "1234");
		});
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("med1", "MEDECIN");
		accountService.addRoleToUser("sec1", "SECRETAIRE");
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("med1", "CHEFSERVICE");

		Medecin med = new Medecin("diallo", "souleymane", null, "laafou", null, "778589587", null, "medecin3", null, true,
				null);
		Medecin med2 = new Medecin("diallo", "BOUBACAR", null, "Labe", null, "778589587", null, "medecin6", null, true,
				null);
		Medecin med3 = new Medecin("diallo", "Mamadou", null, "Mali", null, "778589587", null, "medecin7", null, true,
				null);
		med.setMatricule("002");
		med2.setMatricule("003");
		med3.setMatricule("004");
		med.setPassword(bCryptPasswordEncoder.encode("1234"));
		med2.setPassword(bCryptPasswordEncoder.encode("1234"));
		med3.setPassword(bCryptPasswordEncoder.encode("1234"));

		serviceRepository.save(new Service("neurologie"));
		serviceRepository.save(new Service("pediatrie"));

		departementRepository.save(new Departement("Urgence"));
		Service s = new Service();
		Service s1=new Service();
		s = serviceRepository.save(new Service("cardiologie"));
		s1 = serviceRepository.save(new Service("Service 2"));
		s.setDepartements(departementRepository.save(new Departement("Pediatrie")));
		serviceRepository.saveAndFlush(s);
		med.setService(s);
		med2.setService(s);
		med3.setService(s1);
		medecinRepository.save(med);
		medecinRepository.save(med2);
		medecinRepository.save(med3);
		accountService.addRoleToUser("medecin3", "MEDECIN");
		accountService.addRoleToUser("medecin6", "MEDECIN");
		accountService.addRoleToUser("medecin7", "MEDECIN");
		specialiteRepository.save(new Specialite("dentiste"));
		specialiteRepository.save(new Specialite("chirurgien"));
		specialiteRepository.save(new Specialite("pediatre"));
		
		Page<Service> ser = serviceRepository.findAll(new PageRequest(0, 5));
		ser.forEach(e -> System.out.println(e.getLibelleService()));
		Patient p = new Patient();
		Dossier d = new Dossier();
		d.setLibelleDossier("dossier1");
		d.setNumeroDossier("123");
		d = dossierRepository.save(d);

		p.setNom("diallo");
		p.setPrenom("souleymane");
		p.setDateNaissance(new Date());
		p.setDossier(d);
		p = patientRepository.save(p);
		d.setPatient(p);
		dossierRepository.saveAndFlush(d);

		Antecedent a = new Antecedent();
		Antecedent a1 = new Antecedent();
		Antecedent a2 = new Antecedent();
		AnteDossier aD = new AnteDossier();
		a.setLibelleAntecedent("Palu");
		a1.setLibelleAntecedent("cancer");
		a2.setLibelleAntecedent("tuberculose");
		antecedentRepository.save(a);
		antecedentRepository.save(a1);
		antecedentRepository.save(a2);
		aD.setAntecedents_id(a);

		aD.setDossiers_id(d);
		anteDossierRepository.save(aD);
		aD.setId(null);
		aD.setAntecedents_id(a1);
		aD.setDossiers_id(d);
		anteDossierRepository.save(aD);
		aD.setId(null);
		aD.setAntecedents_id(a2);
		aD.setDossiers_id(d);
		anteDossierRepository.save(aD);
		p = patientRepository.trouverPatientByDossier("123");
		System.out.println("le dossier" + p.getNom());
		Consultation c = new Consultation();
		c = consultationRepository.save(new Consultation(new Date(), "la consultation", "paracetamol, diclofenac"));
		c.setPatients(p);
		c.setMedecins(med);
		consultationRepository.saveAndFlush(c);

	}

	@Bean
	BCryptPasswordEncoder getBCPE() {

		return new BCryptPasswordEncoder();
	}

}
