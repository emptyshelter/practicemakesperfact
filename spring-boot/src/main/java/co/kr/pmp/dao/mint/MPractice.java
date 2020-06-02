package co.kr.pmp.dao.mint;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.kr.pmp.domain.mint.Mdto;

@Mapper
public interface MPractice {
	public List<Mdto>Mtest();
}
