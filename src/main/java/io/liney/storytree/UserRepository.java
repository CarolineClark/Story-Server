
package io.liney.storytree;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<Storyline, Long> {
    List<Storyline> findByPage(@Param("page")String page);
}
