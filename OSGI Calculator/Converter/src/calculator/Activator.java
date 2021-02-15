package calculator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import converter.service.Converter;
import converterImpl.ConverterImpl;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		this.registryConverterService();
		
		System.out.println("OSGi ConverterService Started");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("OSGi ConverterService Stopped!");
	}

	private void registryConverterService() {
		Converter service = new ConverterImpl();
		context.registerService(Converter.class, service, null);
	}

}
