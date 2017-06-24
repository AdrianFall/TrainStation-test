package service;

import dto.QuickestPathDTO;
import model.TrainStation;

/**
 * Created by Adrian on 24/06/2017.
 */
public interface PathFinderService {

    QuickestPathDTO getQuickestPath(TrainStation origin, TrainStation target);

}
