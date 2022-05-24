package hercerm.college.uadyawsfinalproject.service;

import java.util.List;
import java.util.Optional;

public interface GenericCrudService<ENTITY, ID> {
    List<ENTITY> getAll();
    Optional<ENTITY> getById(ID id);
    ENTITY create(ENTITY entity);
    ENTITY update(ENTITY entity, ID id);
    void deleteById(ID id);
}
