/*
 * package org.sfd.gestionHopital.controller;
 * 
 * import org.sfd.gestionHopital.dao.ParametresRepository; import
 * org.sfd.gestionHopital.entities.Parametres; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.access.annotation.Secured; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * @Controller public class ParametresRestService {
 * 
 * @Autowired private ParametresRepository paramRepo;
 * 
 * @Secured(value={"ROLE_ADMIN"})
 * 
 * @RequestMapping(value="/parametrageduree",method=RequestMethod.GET) public
 * String formPatient(Model model){ long id=1; Parametres
 * param=paramRepo.getOne(id); System.out.println(param.getDureeConsultation());
 * model.addAttribute("para",param);
 * 
 * return "paramtrage"; }
 * 
 * @Secured(value={"ROLE_ADMIN"})
 * 
 * @RequestMapping(value="/saveParametre",method=RequestMethod.POST) public
 * String SaveParametre(@RequestParam(name="dureeConsultation")String
 * duree,Model model){
 * 
 * 
 * long id=1; Parametres parametre=paramRepo.getOne(id); int
 * dureeCons=Integer.parseInt(duree); parametre.setDureeConsultation(dureeCons);
 * 
 * paramRepo.save(parametre) ;
 * 
 * 
 * 
 * return "redirect:/parametrageduree"; }
 * 
 * }
 */