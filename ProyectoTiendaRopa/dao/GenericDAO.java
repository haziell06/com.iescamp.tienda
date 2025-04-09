package com.iescamp.tienda.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T, K> {
    void insertar(T obj);
    T obtenerPorId(K id); //obtener por la clave primaria List<T> ();
    List<T> obtenerTodos();
    boolean actualizar(T obj);
    void eliminar(K id);
    T construirDesdeResultSet(ResultSet rs) throws SQLException;
}

