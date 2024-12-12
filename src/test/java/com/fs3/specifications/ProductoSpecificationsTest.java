package com.fs3.specifications;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fs3.model.Producto;

class ProductoSpecificationsTest {

    private Root<Producto> root;
    private CriteriaQuery<?> query;
    private CriteriaBuilder builder;

    @BeforeEach
    void setUp() {
        root = mock(Root.class);
        query = mock(CriteriaQuery.class);
        builder = mock(CriteriaBuilder.class);
    }

    @Test
    void testNombreContains_NotNullOrEmpty() {
        String nombre = "Producto";
        when(builder.like(root.get("nombre"), "%" + nombre + "%")).thenReturn(mock(Predicate.class));

        Predicate predicate = ProductoSpecifications.nombreContains(nombre).toPredicate(root, query, builder);

        assertNotNull(predicate);
        verify(builder, times(1)).like(root.get("nombre"), "%" + nombre + "%");
    }

    @Test
    void testNombreContains_NullOrEmpty() {
        Predicate predicateNull = ProductoSpecifications.nombreContains(null).toPredicate(root, query, builder);
        Predicate predicateEmpty = ProductoSpecifications.nombreContains("").toPredicate(root, query, builder);

        assertNull(predicateNull);
        assertNull(predicateEmpty);
    }
}