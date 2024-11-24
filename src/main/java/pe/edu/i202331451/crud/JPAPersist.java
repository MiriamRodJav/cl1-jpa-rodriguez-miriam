package pe.edu.i202331451.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202331451.entity.City;
import pe.edu.i202331451.entity.Country;
import pe.edu.i202331451.entity.CountryLanguage;

import java.util.Arrays;
import java.util.Date;

public class JPAPersist {
    public static void main(String[] args) {
        //Referenciar al EMF y al EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        //Crear pais-objeto pais
        Country country = new Country("IMA", "Imaginario", "Asia", "Imagine", 0.5,
                1930, 10000, 80.0, 9.0, 4.200, "Piensa y crea",
                "Imagipublic", "Mente", 200, "IM", null, null);

        //Crear objetos ciudades
        City citya = new City("New City", "Newest", 10000, country);
        City cityb = new City("Medium City", "Between", 20000, country);
        City cityc = new City("Old City", "Oldest", 30000, country);

        //Registrar ciudades a Country
        country.setCity(Arrays.asList(citya, cityb, cityc));

        //Crear objetos para Idiomas
        CountryLanguage languagea = new CountryLanguage("Tangamandapio", "F", 5.4, country);
        CountryLanguage languageb = new CountryLanguage("Deuteronomio", "F", 8.4, country);

        country.setCountryLanguages(Arrays.asList(languagea, languageb));

        //registrar Country
        em.getTransaction().begin(); //inicia la transacción
        em.persist(country); //para persistir el País y guardarlo
        em.getTransaction().commit(); //Confirmar los cambios de la creación del Pís

        System.out.println("Registros agregados correctamente");
    }
}
