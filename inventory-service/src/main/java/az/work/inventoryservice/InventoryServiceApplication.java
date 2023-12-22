package az.work.inventoryservice;

import az.work.inventoryservice.entity.Inventory;
import az.work.inventoryservice.repository.InventoryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepo inventoryRepo){
        return args -> {
            Inventory inventory = new Inventory();
            inventory.setSkuCode("Iphone 14");
            inventory.setQuantity(1);

            Inventory inventory1 = new Inventory();
            inventory1.setSkuCode("Iphone 14 Pro Max");
            inventory1.setQuantity(1);

            inventoryRepo.save(inventory);
            inventoryRepo.save(inventory1);

        };
    }
}
