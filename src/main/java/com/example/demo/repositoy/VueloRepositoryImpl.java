package com.example.demo.repositoy;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.example.demo.repositoy.model.Vuelo;

@Repository
@Transactional
public class VueloRepositoryImpl implements IVueloRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void ingresar(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vuelo);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualiza(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.entityManager.merge(vuelo);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Vuelo buscar(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Vuelo> myQuery=this.entityManager.createQuery("SELECT v FROM Vuelo v WHERE v.numero =:datoNumero",Vuelo.class);
		myQuery.setParameter("datoNumero", numero);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Vuelo> buscarVuelos(String origen, String destino, String fecha) {
		// TODO Auto-generated method stub
		
		TypedQuery<Vuelo> myQuery=this.entityManager.createQuery("SELECT v FROM Vuelo v WHERE v.origen =:datoOrigen AND v.destino =:datoDestino AND v.fechaVuelo =:datoFecha",Vuelo.class);
		myQuery.setParameter("datoOrigen", origen);
		myQuery.setParameter("datoDestino", destino);
		myQuery.setParameter("datoFecha", fecha);
		return myQuery.getResultList();
	}

}
