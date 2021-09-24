package annotation;

public class SampleRepository {

    @Transaction
    public void save(){
        System.out.println("SampleRepository.save");
    }

}
