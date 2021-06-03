/*
 * ÖNEMLİ 1 : Doğrulama işlemleri için sahte servisler oluşturunuz. Örneğin, gerçekten mail göndermeniz gerekmez.

ÖNEMLİ 2 : Gereksinimler dışında kodlama yapmayınız. Bu, Proje yönetimi ve ALM (Application LifeCycle Management) kurallarına aykırı bir yazılım geliştirici davranışıdır.


Req 1 : İş Arayanlar sisteme kayıt olabilmelidir.

Kabul Kriterleri:

    +Kayıt sırasında kullanıcıdan ad, soyad, tcno, doğum yılı, e-Posta, şifre, şifre tekrarı bilgileri istenir.
    +Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
    +Mernis doğrulaması yapılarak sisteme kayıt gerçekleştirilir.
    +Doğrulama geçerli değilse kullanıcı bilgilendirilir.
    +Daha önce kayıtlı bir e-posta veya tcno var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.
    Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir.

Req 2 : İş verenler sisteme kayıt olabilmelidir.

Kabul Kriterleri:

    Kayıt sırasında kullanıcıdan şirket adı, web sitesi, web sitesi ile aynı domaine sahip e-posta, telefon, şifre, şifre tekrarı bilgileri istenir. Burada amaç sisteme şirket olmayanların katılmasını engellemektir.
    Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
    Şirket kayıtları iki şekilde doğrulanır. Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir. HRMS personelinin (bizim :)) onayı gerekmektedir.
    Daha önce kayıtlı bir e-posta var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.

Req 3 : Sisteme genel iş pozisyonu isimleri eklenebilmelidir. Örneğin Software Developer, Software Architect.

Kabul Kriterleri:

    Bu pozisyonlar tekrar edemez. Kullanıcı uyarılır.

Req 4 : İş verenler listelenebilmelidir. (Sadece tüm liste)

Req 5 : İş arayanlar listelenebilmelidir. (Sadece tüm liste)

Req 6 : İş pozisyonları listelenebilmelidir. (Sadece tüm liste)
 */
package kodlamaio.hrms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kodlamaio.hrms.business.concretes.CandidateManager;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Admin;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HrmsApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(HrmsApplication.class, args);
		/*
		System.out.println("System started.");
		
		Candidate candidate = new Candidate(1, "Hüseyin", "Biteker", "13865725186", 1982);
		candidate.setEmail("candidate@biteker.com");
		candidate.setPassword("candidate");
		
		Admin admin = new Admin(2,"Melis","Biteker");
		admin.setEmail("admin@biteker.com");
		candidate.setPassword("admin");
		
		Employer employer = new Employer(3, "Biteker Comp.", "biteker.com", "+90 212 123 4567");
		employer.setEmail("employer@biteker.com");
		candidate.setPassword("employer");
		
		ValidationManager validationManager = new ValidationManager();
		
		var result =validationManager.validate(candidate);
		System.out.println(result.getMessage());
		
		var result1 =validationManager.validate(admin);
		System.out.println(result1.getMessage());
		
		var result2 =validationManager.validate(employer);
		System.out.println(result2.getMessage());
		
		MernisServiceAdapter mernis = new MernisServiceAdapter();
		var result3=mernis.validate(candidate);
		System.out.println(result3.getMessage());
		

		CandidateDao candidateDao=null;
		ValidationService[] validationServices = {validationManager,mernis};
		
		
		CandidateManager candidateManager = new CandidateManager(candidateDao, validationServices);
		var result4=candidateManager.add(candidate);
		System.out.println(result4.getMessage());*/
		
	}
	
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("kodlamaio.hrms"))                        
          .build();                                           
    }

}
