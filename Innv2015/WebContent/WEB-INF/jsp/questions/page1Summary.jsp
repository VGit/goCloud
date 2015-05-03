<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<div class="summary-page">
	<h2>Decision Justification</h2>
	<h3>
		Based on your choices <span class="red"><b>${cloudChoice}</b></span>
		is recommended. However, there is no single hosting model that will
		work for all the applications deployed by an organization different
		requirements justify different solutions.
	</h3>
	<span class="red" style="font-size: 16pt;"><b>${cloudChoice}</b></span>
	<c:if test="${decision eq 'internalIT'}">
		<div class="internalIT">
			<p>
				Internal IT enables an organization to meet its IT objectives while
				ensuring security of critical applications, by keeping those
				applications in house. Before running the applications in house,
				organizations need to make long term investment decisions and assess
				the capability of their internal resources to host and effectively
				manage applications.<br>
				<br> Select from:
			<dl class="dl-vertical">
				<dt>Legacy IT</dt>
				<dd>Retaining the applications with legacy IT enables
					organizations to exercise complete control over all aspects of the
					DC architecture and network. An organization's core competency
					applications depend on company specific knowledge. They require
					very specific hardware and platform configurations that can't
					easily be recreated, either externally or on the commodity hardware
					platforms favored for private cloud implementations.</dd>
				<dt>Internal private cloud</dt>
				<dd>Private clouds should be considered by organizations
					looking for the flexibility, agility and elasticity offered by
					external models such as public cloud, but are constrained by
					application requirements that can't be met using external hosting
					solutions.</dd>
			</dl>
		</div>
	</c:if>
	<c:if test="${decision eq 'managedServices' }">
		<div class="managedServices">
			<p>
				Managed Services Organizations that lack the ability, resources or
				desire to deploy, manage and support applications internally should
				explore Managed Service Provider (MSP) offerings. Managed services
				are a good fit for organizations looking for top rated skills,
				monitoring and management expertise, and high service and support
				levels. <br>
				<br>Choices are:
			<dl class="dl-vertical">
				<dt>Outsourced private cloud</dt>
				<dd>For applications that are a good fit for private cloud in
					organizations that lack the skills to build their own private
					cloud, an outsourced private cloud offers an attractive alternative
					that retains many of the benefits of private cloud, but eliminates
					the need to build up the skills and specialized infrastructure.</dd>
				<dt>Hosted private cloud</dt>
				<dd>Outsourced private cloud still requires the purchase of
					infrastructure and sufficient space/power/cooling to host the
					private cloud infrastructure internally, which may not be an option
					for some organizations. In such situations, a hosted private cloud
					is a viable alternative; the infrastructure is installed at the
					hosting provider's facility and managed by the hosting provider's
					staff.</dd>
				<dt>On premises managed services</dt>
				<dd>This is a good alternative when a legacy IT approach is
					required to meet the needs of the application, but the organization
					can no longer support the infrastructure. The MSP takes over the
					existing infrastructure and application (or works with the
					organization to create new infrastructure) at the customer's
					existing site and provides dedicated management staff on site. This
					allows organizations to get better service levels at lower costs.</dd>
				<dt>Remote managed services</dt>
				<dd>Similar in principle to an on premises managed service
					approach, the key difference is that the MSP manages the
					infrastructure and application remotely, rather than providing
					dedicated on site staff. Use of remote managed service will be less
					expensive than on premises approaches, but with some reduction in
					the level of support.</dd>
			</dl>
			</p>
		</div>
	</c:if>
	<c:if test="${decision eq 'colocation' }">
		<div class="colocation">
			Colocation is often seen as the ultimate solution if an organization
			wants to have the flexibility and control of owning the
			infrastructure, but has neither the resources in-house nor the DC
			space to host the infrastructure required to run the workloads.
			Benefits of colocation are far more significant, and range from high
			levels of connectivity to effective management of infrastructure
			located at the colocation facility. Options are:
			<dl class="dl-vertical">
				<dt>Carrier-neutral colocation</dt>
				<dd>Organizations looking for DC space to host applications

					with low latency and high bandwidth requirements to the Internet or
					to other locations should opt for carrier-neutral colocation.
					Carrier-neutral colocations give customers direct access to a wide
					range of service providers, connectivity partners and cloud

					platforms.</dd>

				<dt>Managed colocation</dt>
				<dd>Managed colocation is most appropriate when an organization

					wants to move its infrastructure to the colocation site, but does
					not want to manage the infrastructure. The provider is responsible
					for managing all the hardware installed in the colocation site,
					while the customer continues to manage the application. Managed

					colocation allows customers to use their staff resources for the
					activities that drive revenue for them, while offloading
					infrastructure management to the colocation provider.</dd>
			</dl>
		</div>
	</c:if>
	<c:if test="${decision eq 'publiccloud' }">
		<div class="publiccloud">
			Public Cloud Public cloud becomes a viable option in scenarios where
			elasticity, provisioning agility, scalability and low capital
			expenditure are major drivers, and the application can run on
			standard hardware and software to allow virtualization. Customers
			need to set appropriate security and access policies to gain control
			over the services they are using on public cloud:

			<dl class="dl-vertical">
				<dt>Public cloud IaaS</dt>
				<dd>Public cloud IaaS offers flexible, elastic, scalable and
					agile infrastructure to the customers. Public cloud IaaS is
					suitable when an organization requires compute, storage and network
					as a service but needs to be able to install any application or
					platform. Public cloud IaaS providers offer tools and mechanisms to

					manage the infrastructure with appropriate control.
				<dt>Public cloud PaaS</dt>
				<dd>PaaS is most appropriate when an organization wants to
					build applications on a public infrastructure using a suite of
					services (database, application, identity, etc.) tied together as a
					platform. Using a public PaaS allows increased speed of development
					and deployment at reduced costs and at the expense of potential
					lock-in to the PaaS provider's platform.</dd>
				<dt>Public cloud SaaS</dt>
				<dd>Organizations that do not want to custom-build software and
					are ready to move to the cloud should select commercial SaaS to
					meet their business requirements. SaaS is a complete, turnkey
					application solution (i.e., the IT organization does not build the
					solution, but may configure and integrate it). Users access it via
					a user-centric interface. SaaS is suited for standard business
					applications that do not require much customization.</dd>
			</dl>
		</div>
		<div class="row" style="text-align: center;">

			<a href="${contextPath}/cloudSelect/main"> <img alt="AWS"
				src="${contextPath}/resources/images/aws.png" />
			</a> <a href="${contextPath}/cloudSelect/main"> <img
				alt="Cloud Foundry"
				src="${contextPath}/resources/images/cloudfoundry.jpg">
			</a> <a href="${contextPath}/cloudSelect/main"> <img
				alt="IBM Bluemix"
				src="${contextPath}/resources/images/microsoftazure.jpg">
			</a>
		</div>
	</c:if>
</div>


