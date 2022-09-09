package com.example.demo.repositoy;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.example.demo.repositoy.model.CompraPasaje;
@Repository
@Transactional
public class ComprarPasajeRepositoryImpl implements ICompraPasajeRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void ingresar(CompraPasaje compraPasaje) {
		// TODO Auto-generated method stub
		this.entityManager.persist(compraPasaje);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualiza(CompraPasaje compraPasaje) {
		// TODO Auto-generated method stub
		this.entityManager.merge(compraPasaje);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public CompraPasaje buscar(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<CompraPasaje> myQuery=this.entityManager.createQuery("SELECT cp FROM CompraPasaje cp WHERE cp.numero =:datoNumero",CompraPasaje.class);
		myQuery.setParameter("datoNumero", numero);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<CompraPasaje> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<CompraPasaje> myQuery=this.entityManager.createQuery("SELECT cp FROM CompraPasaje cp",CompraPasaje.class);
		return myQuery.getResultList();
	}

}
