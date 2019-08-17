package org.soyphea;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SongException extends RuntimeException{
    public SongException() {
        super();
    }

    public SongException(String id) {
        super("Song "+id+" Not found!");
    }
}
