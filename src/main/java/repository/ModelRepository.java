package repository;

import model.Model;

public interface ModelRepository {
    public Model findById(final int id);
}
