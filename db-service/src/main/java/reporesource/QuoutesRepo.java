package reporesource;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Qoute;

public interface QuoutesRepo extends JpaRepository<Qoute, Integer> {

	public List<Qoute> findByUserName(String username);
}
