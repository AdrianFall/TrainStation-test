package main.service;

import main.dto.QuickestPathDTO;
import main.exception.PathFinderServiceException;
import main.model.TrainStation;

/**
 * Created by Adrian on 24/06/2017.
 */
public interface PathFinderService {

    QuickestPathDTO getQuickestPath(TrainStation origin, TrainStation target) throws PathFinderServiceException;

}
