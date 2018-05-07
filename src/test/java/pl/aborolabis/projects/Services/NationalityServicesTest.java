package pl.aborolabis.projects.Services;

import org.junit.jupiter.api.Test;
import pl.aborolabis.projects.EntityObjects.Nationality;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NationalityServicesTest {

    private NationalityServices nationalityServices = new NationalityServices();

    @Test
    void findAllNations() {
        List<Nationality> listOfNations = nationalityServices.findAllNations();

        listOfNations.stream().forEach(nationality -> System.out.println(nationality.toString()));
    }

    @Test
    void createANationality(){
        int asgard = nationalityServices.createANationalityWithNameOnly("Asgard");

        System.out.println(asgard);
    }

    @Test
    void findNationByHisId(){
        Nationality nationByHisId = nationalityServices.findNationByHisId(1);

        System.out.println(nationByHisId.toString());
    }
}