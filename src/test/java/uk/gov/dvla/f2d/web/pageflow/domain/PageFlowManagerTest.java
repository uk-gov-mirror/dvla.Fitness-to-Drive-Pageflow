package uk.gov.dvla.f2d.web.pageflow.domain;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import uk.gov.dvla.f2d.model.enums.Condition;
import uk.gov.dvla.f2d.model.enums.Service;
import uk.gov.dvla.f2d.model.pageflow.MedicalCondition;
import uk.gov.dvla.f2d.model.pageflow.MedicalForm;
import uk.gov.dvla.f2d.model.pageflow.MedicalQuestion;
import uk.gov.dvla.f2d.web.pageflow.cache.PageFlowCacheManager;
import uk.gov.dvla.f2d.web.pageflow.processor.summary.SummaryLine;

import java.util.List;
import java.util.Map;

public class PageFlowManagerTest extends TestCase
{
    private MedicalForm form;

    public PageFlowManagerTest(String testName ) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite( PageFlowManagerTest.class );
    }

    public void setUp() throws Exception {
        PageFlowCacheManager cache = PageFlowCacheManager.getInstance();
        Map<String, MedicalCondition> conditions = cache.getConditions(Service.NOTIFY);

        form = cache.createMedicalForm(Service.NOTIFY);
        form.setMedicalCondition(conditions.get(Condition.DIABETES.getName()));
    }

    public void tearDown() throws Exception {
        form = null;
    }

    public void testSupportedConditions() throws Exception {
        PageFlowManager manager = new PageFlowManager(form);
        Map<String, MedicalCondition> supported = manager.getConditions();

        assertTrue("No conditions found.", supported.size() > 0);
    }

    public void testFindQuestion() throws Exception {
        PageFlowManager manager = new PageFlowManager(form);
        MedicalQuestion question = manager.getQuestion("5");

        assertEquals("confirm-address", question.getID());
    }

    public void testSummaryTransformation() throws Exception {
        PageFlowManager manager = new PageFlowManager(form);
        List<SummaryLine> summary = manager.transform();

        assertNotNull(summary);
        assertEquals(0, summary.size());
    }
}