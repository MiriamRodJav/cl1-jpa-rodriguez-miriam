package pe.edu.i202331451.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202331451.entity.City;
import pe.edu.i202331451.entity.Country;

import java.util.List;
import java.util.stream.Collectors;

public class JPAFind {
    public static void main(String[] args) {
        // referenciar al EMF y EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        // buscar el país por codigo
        Country country = em.find(Country.class, "PER");

        List<City> cities = country.getCity().stream()
                .filter((city) -> {
                    return city.getPopulation() > 700000;
                })
                .collect(Collectors.toList());

        cities.forEach((city) -> {
            System.out.println(city.getName());
        });
    }
}
