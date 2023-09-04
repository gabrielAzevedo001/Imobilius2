package br.com.imobilius2.domain.imovel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {

    Page<Imovel> findAllByAtivoTrue(Pageable paginacao);
}
