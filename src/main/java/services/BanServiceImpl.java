package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Ban;
import repositories.BanRepository;

@Service
public class BanServiceImpl implements BanService{
	
	@Autowired
	private BanRepository banRepository;

	@Autowired
    public BanServiceImpl(BanRepository banRepository) {
        this.banRepository = banRepository;
    }
	
	
	@Override
	public List<Ban> listAll() {
		List<Ban> bans = new ArrayList<Ban>();
		bans = banRepository.findAll();
        return bans;
	}

	@Override
	public Ban getById(String id) {
		return banRepository.findOne(id);
	}
	
	@Override
	public Ban getByUserId(String userId) {
		return banRepository.findOne(userId);
	}

	@Override
	public Ban saveOrUpdate(Ban ban) {
		return banRepository.save(ban);
	}

	@Override
	public void delete(String id) {
		banRepository.delete(id);
	}
		
}
