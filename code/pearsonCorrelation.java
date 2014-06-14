public class MyDirctedGraph{
    private DirectedSparseGraph<Node, Link> mGraph;
    // ... members, methods ...

    public double getPearsonsCorrelation() {
        int numLinks = mGraph.getEdgeCount();
        double[] degSrc = new double[numLinks];
        double[] degDst = new double[numLinks];

        Collection<Link> links = mGraph.getEdges();
        Iterator<Link> lit = links.iterator();
        int i = 0;
        while (lit.hasNext()) {
            Link l = lit.next();
            Pair<Node> endPoints = mGraph.getEndpoints(l);
            degSrc[i] = mGraph.inDegree(endPoints.getFirst());
            degDst[i] = mGraph.inDegree(endPoints.getSecond());
            i++;
        }

        PearsonsCorrelation pc = new PearsonsCorrelation();
        return pc.correlation(degSrc, degDst);
    }
}
