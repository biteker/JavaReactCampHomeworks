/*
Aşağıda bir e-ticaret sisteminde sisteme kayıt ve sisteme giriş için gerekli gereksinim ve kabul kriterlerini yazdım. Bu sisteme ait Java backend yazmak istiyoruz.

Kullanıcılar sisteme bilgilerini girerek üye olabilmelidir.

    Sisteme temel kullanıcı bilgileri , e-posta ve parolayla üye olunabilmelidir. Temel kullanıcı bilgileri : ad, soyad, e-posta, parola. Temel bilgilerin tamamı zorunludur.
    Parola en az 6 karakterden oluşmalıdır.
    E-posta alanı e-posta formatında olmalıdır. (Regex ile yapınız. Araştırma konusu)
    E-Posta daha önce kullanılmamış olmalıdır.
    Ad ve soyad en az iki karakterden oluşmalıdır.
    Üyelik sonucu kullanıcıya doğrulama e-postası gönderilmelidir. (Simulasyon)
    Doğrulama linki tıklandığında üyelik tamamlanmalıdır. (Simulasyon)
    Hatalı veya başarılı durumda kullanıcı bilgilendirilmelidir.

Kullanıcılar sisteme Google hesapları ile üye olabilmelidir. (Simulasyon)

    İlerleyen zamanlarda başka yetkilendirme servisleri de kullanılabilir. (Sistemi dış servis entegrasyonu olacak şekilde yapılandırınız.)
    Hatalı veya başarılı durumda kullanıcı bilgilendirilmelidir.

Kullanıcılar e-posta ve parola bilgisiyle sisteme giriş yapabilmelidir.

    E-posta ve parola zorunludur
    Hatalı veya başarılı durumda kullanıcı bilgilendirilmelidir.


Bu isterleri katmanlı mimaride simüle ediniz.

Github adresinizi paylaşınız.

Diğer arkadaşlarınınız projelerini inceleyiniz. Beğenirseniz yıldızlayın :)

Kısıt : Hiç bir ek paket kullanmayınız. Tamamen gördüklerimizden ilerleyiniz.
 */

package eCommerceSystem;

import java.util.List;

import eCommerceSystem.business.abstracts.CustomerService;
import eCommerceSystem.business.abstracts.ValidationService;
import eCommerceSystem.business.concretes.CustomerManager;
import eCommerceSystem.business.concretes.CustomerValidationManager;
import eCommerceSystem.business.concretes.EmailValidationManager;
import eCommerceSystem.dataAccess.concretes.InMemoryCustomerDao;
import eCommerceSystem.entities.concretes.Customer;

public class Main {

	public static void main(String[] args) {
		Customer customer1 = new Customer("Huseyin","Biteker","biteker@gmail.com.tr","123456");
		Customer customer2 = new Customer("Melis","Biteker","melisbiteker@gmail.com","654321");
		Customer customer3 = new Customer("Yiğit","Biteker","biteker@gmail.com","987654");
		
		Customer[] customers = {customer1,customer2,customer3};
		
		ValidationService[] validationService = {new EmailValidationManager(), new CustomerValidationManager()};
		
		CustomerService customerService = new CustomerManager(new InMemoryCustomerDao(), validationService);
		
		customerService.add(customer1);
		customerService.add(customer2);
		customerService.add(customer3);
		
		customerService.add(customers);
		
		for (Customer customer : customerService.getAll()) {
			System.out.println("Müşteri adı: " + customer.getName());
		}
	}
}
