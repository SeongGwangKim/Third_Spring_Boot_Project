package SupplementsWeb.com.dao;

import SupplementsWeb.com.domain.Board;
import SupplementsWeb.com.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by KimYJ on 2017-07-12.
 */
@Repository
public interface BoardDaoImpl extends JpaRepository<Board, Long> {
    Board findByUser(User user);
}
