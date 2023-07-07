package com.graphql.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.example.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
	
//		@Query("SELECT a FROM author_details a inner join book_data b on a.author_id = :id")
//		public List<Author> findAuthorsById(int id);

	}
	
//		@PersistenceContext 
//	 	private EntityManager entityManager;
//    
//	    public List<Author> findById(int id) {
//	        String jpql = "SELECT * FROM author_details a inner join book_data b on a.author_id = :id";
//	        TypedQuery<Author> query = entityManager.createQuery(jpql, Author.class);
//	         
//	        return query.getResultList();
//	    }

