using JetBrains.Lifetimes;
using JetBrains.ProjectModel;
using Rider.Plugins.TddBuddy.Model;

namespace Rider.Plugins.TddBuddy;

[SolutionComponent]
public class TestStatusBroadcaster
{
    private readonly RdTddBuddyModel _model;

    public TestStatusBroadcaster(ISolution solution)
    {
        _model = solution.GetProtocolSolution().GetRdTddBuddyModel();
    }

    public void BroadcastTestStatus(bool hasFailedTests, string firstFailedTestName)
    {
        var update = new RdTestStatusUpdate(hasFailedTests, firstFailedTestName ?? "");
        _model.TestStatusUpdated.Fire(update);
    }
}
