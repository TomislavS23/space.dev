package dev.space.query.operation;

import dev.space.dto.ArticleDTO;
import java.util.List;

/**
 *
 * @author tomislav
 */
public interface ArticleOperations extends BaseOperations<ArticleDTO> {

    List<ArticleDTO> ReadAllEntities();
}
