package de.jluger.jugn_vortrag.sample005;

import org.junit.Assert;
import org.junit.Test;

public class Sample005ViewModelTest {
	@Test
	public void testCalcDisabledByDefault() {
		Sample005ViewModel viewModel = new Sample005ViewModel();
		Assert.assertTrue(viewModel.getCalcDisableProperty().getValue());
	}

	@Test
	public void testCalcDisabledByOp1Only() {
		Sample005ViewModel viewModel = new Sample005ViewModel();
		viewModel.getOp1Formatter().setValue(10.0);
		Assert.assertTrue(viewModel.getCalcDisableProperty().getValue());
	}

	@Test
	public void testCalcDisabledByOp2Only() {
		Sample005ViewModel viewModel = new Sample005ViewModel();
		viewModel.getOp2Formatter().setValue(10.0);
		Assert.assertTrue(viewModel.getCalcDisableProperty().getValue());
	}
	
	@Test
	public void testCalcEnabledByTwoOps() {
		Sample005ViewModel viewModel = new Sample005ViewModel();
		viewModel.getOp1Formatter().setValue(10.0);
		viewModel.getOp2Formatter().setValue(5.0);
		Assert.assertFalse(viewModel.getCalcDisableProperty().getValue());
	}
	
	@Test
	public void testCalcPlus() {
		Sample005ViewModel viewModel = new Sample005ViewModel();
		viewModel.getOp1Formatter().setValue(10.0);
		viewModel.getOp2Formatter().setValue(5.0);
		viewModel.calculate();
		Assert.assertEquals("15.0", viewModel.getResultProperty().getValue());
	}
	
	@Test
	public void testCalcMinus() {
		Sample005ViewModel viewModel = new Sample005ViewModel();
		viewModel.getOp1Formatter().setValue(10.0);
		viewModel.getOp2Formatter().setValue(5.0);
		viewModel.getSelectedOperationItem().setValue(viewModel.getOperationList().get(1));
		viewModel.calculate();
		Assert.assertEquals("5.0", viewModel.getResultProperty().getValue());
	}
}
