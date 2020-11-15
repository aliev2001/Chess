package repository.interfaces;

import java.util.Set;

import model.Club;

public interface IClubRepository extends IEntityRepository<Club> {
	Set<Club> getAll();
	boolean addUserToClub(long userId, long clubId);
	boolean deleteUserFromClub(long userId, long clubID);
}
