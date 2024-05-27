package kodlama.io.Devs.dataAccess.abstracts;


import kodlama.io.Devs.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer> {
    Language findByName(String name);

}
