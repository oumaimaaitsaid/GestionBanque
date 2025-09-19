package test;

import com.banque.repository.CompteRepository;
import com.banque.service.CompteService;
import com.banque.exception.CompteException;


public class CompteServiceTest extends TestBase {

  private CompteService service;
  private CompteRepository repo;
  
  
  public CompteServiceTest(){
	  this.repo =new CompteRepository();
	  this.service =new CompteService(repo);
  }
  
  
  public void testCreateCompteCourant() {
	  
	  String code =service.createCompteCourant(10000, 500);
	  this.assertEquals(true, repo.findByCode(code).isPresent(), "testCreateCompteCourant");
  }
  
  
  public void testVersement() {
	  String code =service.createCompteCourant(0, 500);
	  try {
		  service.verser(code, 300 ,"Dépot initial");
		  this.assertEquals(300.0,service.consulterSolde(code) , "testVersement");
		  
		  
	  }catch(CompteException e) {
		  this.assertEquals(null, e, "testVersement -exception ");
		  
	  }
  }
  public void testRetraitAvecException() {
      String code = service.createCompteCourant(100, 0);
      this.assertThrows(
  		    () -> {
  		        try {
  		            service.retirer(code, 500);
  		        } catch (CompteException e) {
  		            throw new RuntimeException(e); 
  		        }
  		    },
  		    RuntimeException.class, 
  		    "testRetraitAvecException"
  		);
  }
  

  public void testVirement() {
	  String from = service.createCompteCourant(500, 0);
	  String to = service.createCompteCourant(100, 0);
  
  try {
	  service.virement(from ,to, 200);
	  this.assertEquals(300.0, service.consulterSolde(from),"testVirement - solde source");
	  this.assertEquals(300.0, service.consulterSolde(to),"testVirement - solde distination");
  }
catch(CompteException e){
	this.assertEquals(null, e, "testVirement - exception inattendue");
	
}
  }
  
  
  public static void main(String[] args) {
	  CompteServiceTest test =new CompteServiceTest();
      test.testCreateCompteCourant();
      test.testVersement();
      test.testRetraitAvecException();
      test.testVirement();
      test.printResult();
  }
  
  
}
