package org.soyphea;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

public interface SongRepository extends CrudRepository<Song,String> {


   List findBySingerName(String singerName);
}
