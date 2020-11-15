package repository.interfaces;

import model.Club;

import java.util.List;

public interface IClubRepository extends IEntityRepository<Club> {
    List<Club> getAllClub();
}
