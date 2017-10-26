package at.spengergasse.weiss.persistence.message;

import at.spengergasse.weiss.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>, QueryDslPredicateExecutor<Message>, MessageRepositoryCustom {

}