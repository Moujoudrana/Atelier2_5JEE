package org.sid.Atelier2;

import org.sid.Atelier2.entities.BankAccount;
import org.sid.Atelier2.entities.Customer;
import org.sid.Atelier2.enums.AccountType;
import org.sid.Atelier2.repositories.BankAccountRepository;
import org.sid.Atelier2.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class Atelier2Application {

	public static void main(String[] args) {
		SpringApplication.run(Atelier2Application.class, args);
	}

	@Bean //pour qu'il sexecute lors du demarrage
	CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
		return args->{
			Stream.of("Mohamed","Rana","Hanaa","Imane").forEach(c->{
				Customer customer=Customer.builder()
						.name(c)
						.build();
				customerRepository.save(customer);
			});
			customerRepository.findAll().forEach(customer -> {
				for(int i=0;i<10;i++){
					BankAccount bankAccount=BankAccount.builder()
							.id(UUID.randomUUID().toString())
							.type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
							.balance(10000+Math.random()*90000)
							.createdAt(new Date())
							.currency("MAD")
							.customer(customer)
							.build();
					bankAccountRepository.save(bankAccount);
				}
			});
		};

	}
}
