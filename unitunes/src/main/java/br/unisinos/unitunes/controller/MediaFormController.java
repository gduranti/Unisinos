package br.unisinos.unitunes.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;
import org.primefaces.event.FileUploadEvent;

import br.unisinos.unitunes.business.media.MediaFacade;
import br.unisinos.unitunes.infra.faces.FacesUtil;
import br.unisinos.unitunes.infra.impl.FormController;
import br.unisinos.unitunes.infra.session.SessionController;
import br.unisinos.unitunes.model.Media;
import br.unisinos.unitunes.model.MediaType;

@Named
@ViewAccessScoped
public class MediaFormController extends FormController<Media> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MediaFacade facade;

	@Inject
	private SessionController sessionController;

	private String thumbFileName;

	@PostConstruct
	public void initFacade() {
		setFacade(facade);
	}

	public List<MediaType> getMediaTypes() {
		return Arrays.asList(MediaType.values());
	}

	public String getThumbFileName() {
		return thumbFileName;
	}

	@Override
	protected Media createModelInstance() {
		Media media = new Media();
		media.setAuthor(sessionController.getUser());
		return media;
	}

	public void handleFileUpload(FileUploadEvent event) {
		getModel().setContent(event.getFile().getContents());
		getModel().setFileName(event.getFile().getFileName());
	}

	public void handleThumbUpload(FileUploadEvent event) {
		getModel().setThumb(event.getFile().getContents());
		thumbFileName = event.getFile().getFileName();
	}

	@Override
	public void save() {

		boolean isInclusion = isInclusion();

		super.save();

		if (isInclusion) {
			FacesUtil.addInfoMessage("M�dia inclu�da com sucesso.");
		} else {
			FacesUtil.addInfoMessage("M�dia alterada com sucesso.");
		}
	}

	@Override
	public String getViewTitle() {
		return isInclusion() ? "Nova M�dia" : "M�dia";
	}

}