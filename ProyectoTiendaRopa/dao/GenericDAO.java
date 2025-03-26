package com.iescamp.tienda.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface GenericDAO<T, K> {
    void insertar(T obj);
    T obtenerPorId(K id); //obtener por la clave primaria List<T> ();
    void actualizar(T obj);
    void eliminar(K id);
    T construirDesdeResultSet(ResultSet rs) throws SQLException;
}

