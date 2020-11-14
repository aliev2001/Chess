package service;

import model.Club;
import model.User;
import repository.ClubRepository;
import repository.interfaces.IClubRepository;
import service.interfaces.IClubService;

public class ClubService implements IClubService {

	private final IClubRepository clubRepository = new ClubRepository();

	@Override

	public Club read(long id) {
		return clubRepository.read(id);
	}

	@Override
	public boolean create(Club user) {
		return clubRepository.create(user);
	}

	@Override
	public boolean delete(long id) {
		return clubRepository.delete(id);
	}

	@Override
	public boolean edit(Club user) {
		return clubRepository.edit(user);
	}

}
