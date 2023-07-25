

<?php $__env->startSection('title', 'Modifica offerta'); ?>

<?php $__env->startSection('content'); ?>
    <div class="wrapper">
        <div class="form-box form-box-inputdialog login">
            <?php if(isset($dati)): ?>
            <h2>Aggiorna Offerte</h2>
            <br>

            <?php echo e(Form::open(array('url' => '/aggiornaOfferte/'.$dati['id'], 'class' => 'contact-form', 'method'=>'PUT', 'enctype' => 'multipart/form-data'))); ?>

            <?php echo csrf_field(); ?>
            <div class="form-row">
                <div class="form-left">
                    <fieldset title="Aggiorna dati offerta">
                        <?php echo e(Form::label('nome', 'Nome', ['class' => 'label-input'])); ?>

                        <?php echo e(Form::text('nome', $dati['nome'], ['class' => 'input', 'id' => 'nome', 'required' => 'required'])); ?>

                        <?php if($errors->first('nome')): ?>
                            <ul class="errors">
                                <?php $__currentLoopData = $errors->get('nome'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                    <li><?php echo e($message); ?></li>
                                <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                            </ul>
                        <?php endif; ?>

                        <?php echo e(Form::label('oggettto', 'Oggetto', ['class' => 'label-input'])); ?>

                        <?php echo e(Form::text('oggetto', $dati['oggetto'], ['class' => 'input', 'id' => 'oggetto', 'required' => 'required'])); ?>

                        <?php if($errors->first('oggetto')): ?>
                            <ul class="errors">
                                <?php $__currentLoopData = $errors->get('oggetto'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                    <li><?php echo e($message); ?></li>
                                <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                            </ul>
                        <?php endif; ?>

                        <label for="idAzienda">Azienda:</label>
                        <p><em>Azienda attuale: <?php echo e($dati['idAzienda']); ?></em></p>
                        <select id="idAzienda" name="idAzienda" required>
                            <option value="NULL">seleziona</option>
                            <?php $__currentLoopData = $ListaNomi; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $listaNomi): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <option value="<?php echo e($listaNomi['id']); ?>"><?php echo e($listaNomi['id']); ?>: <?php echo e($listaNomi['nome']); ?></option>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </select>

                        <?php echo e(Form::label('modalitaFruizione', 'Modalità di fruizione', ['class' => 'label-input'])); ?>

                        <?php echo e(Form::text('modalitaFruizione', $dati['modalitaFruizione'], ['class' => 'input', 'id' => 'modalitaFruizione', 'required' => 'required'])); ?>

                        <?php if($errors->first('modalitaFruizione')): ?>
                            <ul class="errors">
                                <?php $__currentLoopData = $errors->get('modalitaFruizione'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                    <li><?php echo e($message); ?></li>
                                <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                            </ul>
                        <?php endif; ?>
                    </fieldset>
                </div>

                <div class="form-right">
                    <fieldset title="Inserisci dati offerta">
                        <?php echo e(Form::label('luogoFruizione', 'Luogo di fruizione', ['class' => 'label-input'])); ?>

                        <?php echo e(Form::text('luogoFruizione', $dati['luogoFruizione'], ['class' => 'input', 'id' => 'luogoFruizione', 'required' => 'required'])); ?>

                        <?php if($errors->first('luogoFruizione')): ?>
                            <ul class="errors">
                                <?php $__currentLoopData = $errors->get('luogoFruizione'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                    <li><?php echo e($message); ?></li>
                                <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                            </ul>
                        <?php endif; ?>

                        <?php echo e(Form::label('dataOraScadenza', 'Data e ora di scadenza', ['class' => 'label-input'])); ?>

                        <?php echo e(Form::datetimeLocal('dataOraScadenza', $dati['dataOraScadenza'] ,['class' => 'input', 'id' => 'dataOraScadenza', 'rules' => 'date_format:d-m-Y H:mm:ss', 'required' => 'required'])); ?>

                        <?php if($errors->first('dataOraScadenza')): ?>
                            <ul class="errors">
                                <?php $__currentLoopData = $errors->get('dataOraScadenza'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                    <li><?php echo e($message); ?></li>
                                <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                            </ul>
                        <?php endif; ?>

                        <fieldset title="Carica immagini in formato .png o .jpeg">
                            <?php echo e(Form::label('immagine','Immagine della offerta', ['class' => 'label-input'])); ?>

                            <p><em>Immagine attualmete selezionata:</em></p>
                            <img src="data:image/png/jpg/webp/jpeg/bin;base64,<?php echo e(base64_encode($dati['immagine'])); ?>" class="form-image-input-preview" alt="Immagine Offerta">
                            <?php echo e(Form::file('immagine')); ?>

                            <?php if($errors->first('immagine')): ?>
                                <ul class="errors">
                                    <?php $__currentLoopData = $errors->get('immagine'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                        <li><?php echo e($message); ?></li>
                                    <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                                </ul>
                            <?php endif; ?>
                        </fieldset>
                    </fieldset>
                </div>
            </div>

            <?php echo e(Form::submit('Aggiorna offerta', ['class' => 'btn'])); ?>

            <?php echo e(Form::close()); ?>


            <?php else: ?>
                <h1>Errore: l'offerta selezionata non è disponibile nel database.</h1>
            <?php endif; ?>

            <div class="panel-buttons">
                <a class="btn btn-back" href="<?php echo e(route('gestioneOfferte')); ?>">Torna indietro</a>
            </div>
        </div>
    </div>
<?php $__env->stopSection(); ?>


<?php echo $__env->make('layouts.skel', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Applicazioni\XAmpp\download\htdocs\ProgettoTecnologieWeb\resources\views/staff/aggiornaOfferte.blade.php ENDPATH**/ ?>