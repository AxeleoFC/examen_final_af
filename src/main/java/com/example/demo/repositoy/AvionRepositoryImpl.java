package com.example.demo.repositoy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.example.demo.repositoy.model.Avion;
@Repository
@Transactional
public class AvionRepositoryImpl implements IAvionRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void ingresar(Avion avion) {
		// TODO Auto-generated method stub
		this.entityManager.persist(avion);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualiza(Avion avion) {
		// TODO Auto-generated method stub
		this.entityManager.merge(avion);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Avion buscar(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Avion> myQuery=this.entityManager.createQuery("SELECT a FROM Avion a WHERE a.numero =:datoNumero",Avion.class);
		myQuery.setParameter("datoNumero", numero);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Avion buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Avion.class, id);
	}

}
