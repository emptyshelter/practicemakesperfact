package co.kr.pmp.service.mint.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.pmp.dao.mint.MPractice;
import co.kr.pmp.domain.mint.Mdto;
import co.kr.pmp.service.mint.MService;

@Service
public class MServiceImpl implements MService{
	@Autowired
	private MPractice mPractice;
	public MServiceImpl() {
	}
	
	public List<Mdto>Mtest(){
		return mPractice.Mtest();
	}
}
