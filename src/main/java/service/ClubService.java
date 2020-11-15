package service;

import java.util.Set;
import java.util.Stack;

import model.Club;
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

	@Override
	public Set<Club> getAll() {
		return clubRepository.getAll();
	}

	@Override
	public Stack<Club> getUserClubs(long userId) {
		return clubRepository.getUserClubs(userId);
	}

}
