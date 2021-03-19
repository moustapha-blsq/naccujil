package sn.moustapha.repository;

import sn.moustapha.domain.Parent;

public interface ParentRepository {
    void parentRegistering();
    Parent findParentByID(int id);
}
