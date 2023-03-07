package tn.spring.springboot.service;


import tn.spring.springboot.entities.Departement;

import java.io.ByteArrayInputStream;
import java.util.List;


public interface ServicePdf {
    ByteArrayInputStream exportPDF(List<Departement> departements);
}
