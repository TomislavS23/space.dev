package dev.space.query.operation;

import dev.space.dto.JournalistDTO;
import java.util.List;

/**
 *
 * @author tomislav
 */
public interface JournalistOperations extends BaseOperations<JournalistDTO> {
    List<JournalistDTO> ReadAllEntities();
}
