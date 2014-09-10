package Flog.Shape;

import Flog.*;
import Flog.Material.*;

public class BaseShape {
    public Vector3D position;
    public BaseMaterial material;

    public IntersectionInfo intersect(Ray ray) {
        return null;
    }
}
